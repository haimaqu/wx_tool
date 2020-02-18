//package com.imooc.wx_tool.servlet;
//
//import com.imooc.wx_tool.po.TextMessageUtil;
//import com.imooc.wx_tool.util.MessageUtil;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Map;
//
///**
// *
// * 类名称: LoginController
// * 类描述: 与微信对接登陆验证
// * @author yuanjun
// * 创建时间:2017年12月5日上午10:52:13
// */
//@Controller
//public class LoginController {
//
//
//    @RequestMapping(value = "wx",method= RequestMethod.GET)
//    public void login(HttpServletRequest request, HttpServletResponse response){
//        System.out.println("success");
//        String signature = request.getParameter("signature");
//        String timestamp = request.getParameter("timestamp");
//        String nonce = request.getParameter("nonce");
//        String echostr = request.getParameter("echostr");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            if(CheckUtil.checkSignature(signature, timestamp, nonce)){
//                out.write(echostr);
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }finally{
//            out.close();
//        }
//
//    }
//
//
//   // @EnableWebSecurity(csrf=DisableOnDebug)
//   //@RequestMapping(path = "wxdemo",method=RequestMethod.POST)
//
////    @RequestMapping(value = "/{pathURL}", method = RequestMethod.POST)
////    public String post(@ModelAttribute("AppUser") AppUser appUser, ModelMap modelMap, @PathVariable String pathURL)
//
//    @RequestMapping(path = "*",method= RequestMethod.POST)
//    public void dopost(HttpServletRequest request, HttpServletResponse response){
//        response.setCharacterEncoding("utf-8");
//        PrintWriter out = null;
//        //将微信请求xml转为map格式，获取所需的参数
//        Map<String,String> map = MessageUtil.xmlToMap(request);
//        String ToUserName = map.get("ToUserName");
//        String FromUserName = map.get("FromUserName");
//        String MsgType = map.get("MsgType");
//        String Content = map.get("Content");
//
//        String message = null;
//        //处理文本类型，实现输入1，回复相应的封装的内容
//        if("text".equals(MsgType)){
//            if("1".equals(Content)){
//                //TextMessageUtil textMessage = new TextMessageUtil();
//                TextMessageUtil textMessage = new TextMessageUtil();
//                message = textMessage.initMessage(FromUserName, ToUserName);
//            }
//        }
//        try {
//            out = response.getWriter();
//            //out.write(message);
//            out.print(message);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        out.close();
//    }
//}
