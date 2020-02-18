package com.imooc.wx_tool.controller;

import com.imooc.wx_tool.constants.MenuKey;
import com.imooc.wx_tool.handler.HelpDocHandler;
import com.imooc.wx_tool.handler.RankHandler;
import com.imooc.wx_tool.handler.WhoAmIHandler;
//import com.imooc.wx_tool.matcher.WhoAmIMatcher;
import com.imooc.wx_tool.matcher.WhoAmIMatcher;
import com.imooc.wx_tool.po.TextMessageUtil;
import com.imooc.wx_tool.servlet.CheckUtil;
import com.imooc.wx_tool.util.MessageUtil;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageRouter;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.util.xml.XStreamTransformer;
import com.sun.corba.se.spi.activation.ServerHeldDownHelper;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxController {
    //对接微信服务器
    //初始化统一API调用入口
    private IService iService = new WxService();

    public static String Signature;
    public static String Timestamp;
    public static String Nonce;

    @GetMapping
    public String check(String signature, String timestamp, String nonce, String echostr) {
        //  	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。  时间戳   随机数  	随机字符串
        if (iService.checkSignature(signature, timestamp, nonce, echostr)) {
            Signature = signature;
            Timestamp = timestamp;
            Nonce = nonce;
            return echostr;
        }
        return null;
    }

    //post接收方法，来接收发来的消息
    @PostMapping
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //是一个输出流
        PrintWriter out = response.getWriter();
        //实例化消息路由器，作用是将消息路由去匹配器，拦截器，处理器。
        WxMessageRouter router = new WxMessageRouter(iService);
        try {
            //微信服务器推送过来的是xml格式
            //WxXmlMessage类是统一的消息载体  所有消息包括事件推送都包含在这个类当中
            //来自微信服务器的消息
            WxXmlMessage wx = XStreamTransformer.fromXml(WxXmlMessage.class, request.getInputStream());
            System.out.println("消息: \n" + toString());
            ////////////////////////
            String ToUserName = wx.getToUserName();
            String FromUserName = wx.getFromUserName();
            String MsgType = wx.getMsgType();
            String Content = wx.getContent();
            String message = null;
            TextMessageUtil textMessage = new TextMessageUtil();
            if ("text".equals(MsgType)) {
                if ("1".equals(Content)) {
                    //TextMessageUtil textMessage = new TextMessageUtil();
                    message = textMessage.initMessage(FromUserName, ToUserName, TextMessageUtil.firstMenu());
                } else if ("2".equals(Content)) {
                    message = textMessage.initNewsMessage(ToUserName, FromUserName);
                } else if ("?".equals(Content) || "？".equals(Content)) {
                    message = textMessage.initMessage(FromUserName, ToUserName, TextMessageUtil.menuText());
                }
                //判断请求是否事件类型 event
            } else if ("event".equals(MsgType)) {
                String eventType = wx.getEvent();
                //若是关注事件  subscribe
                if ("subscribe".equals(eventType)) {
                    message = textMessage.initMessage(FromUserName, ToUserName, TextMessageUtil.menuText());
                } else if ("scancode_push".equals(eventType)) {//扫码事件
                    String key = wx.getEventKey();
                    message = textMessage.initMessage(FromUserName, ToUserName, key);
                }
            } else if ("location".equals(MsgType)) {//获取位置信息
                String label = wx.getLabel();
                message = textMessage.initMessage(ToUserName, FromUserName, label);
            }

            out = response.getWriter();
            out.print(message);
            //out.close();

            /**
             *  router.rule().event(WxConsts.EVT_CLICK).eventKey(MenuKey.HELP).handler(HelpDocHandler.getInstance()).end();
             *   路由器规则
             *   next() 表示消息经过第一个规则（Rule）之后，允许继续匹配下面的规则，代表着同一个消息有可能被多个Handler处理。
             *   end() 表示规则的结束。当消息满足某条规则时遇到end()，不会再往下匹配规则，就此结束。
             *
             * 添加路由规则，只处理满足规则的消息，可以自定义匹配器，拦截器，处理。
             * 每条路由规则必须以next()或者end()结束。否则不生效。这个后续会讲到。
             * 这里意思是，只接收TEXT类型的消息，交给DemoMatcher匹配器、DemoInterceptor拦截器、DemoHandler处理器处理。
             */
            router.rule().msgType(WxConsts.XML_MSG_TEXT).matcher(new WhoAmIMatcher()).handler(new WhoAmIHandler()).end()
                    .rule().event(WxConsts.EVT_CLICK).eventKey(MenuKey.HELP).handler(HelpDocHandler.getInstance()).next()
                    .rule().eventKey(MenuKey.HOT_SONG).handler(RankHandler.getInstance()).next()
                    .rule().eventKey(MenuKey.TOP_500).handler(RankHandler.getInstance()).next()
                    .rule().eventKey(MenuKey.NET_HOT_SONG).handler(RankHandler.getInstance()).next()
                    .rule().eventKey(MenuKey.HUAYU_SONG).handler(RankHandler.getInstance()).next()
                    .rule().eventKey(MenuKey.XINAO_SONG).handler(RankHandler.getInstance()).end();
            // 把消息传递给路由器进行处理   将WxXmlMessage交给消息路由器，处理后得到结果。
            //开始路由
            //router.route(wx);
            WxXmlOutMessage xmlOutMessage = router.route(wx);
            if (xmlOutMessage != null) {
                //因为 是明文，所以不用加密。直接返回给用户
                out.println(xmlOutMessage.toXml());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }


}
