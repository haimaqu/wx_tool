package com.imooc.wx_tool.web;

import com.alibaba.fastjson.JSON;
import com.imooc.wx_tool.entity.Addr;
import com.imooc.wx_tool.entity.User;
import com.imooc.wx_tool.repository.AddrRepository;
import com.imooc.wx_tool.service.AddrService;
import com.imooc.wx_tool.service.UserService;
import com.imooc.wx_tool.util.JsapiTicketUtil;
import com.imooc.wx_tool.utils.WeixinUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AddrController {

    @Resource
    AddrService addrService;
    @Resource
    UserService userService;
    @Resource
    AddrRepository addrRepository;

    protected void sendJsonData(HttpServletResponse response, String data)
            throws Exception
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(data);
        out.flush();
        out.close();
    }

    @RequestMapping(value="/listsp")
    public ModelAndView wxJsSdkConfig(HttpServletRequest request, HttpServletResponse response){
        String url = request.getRequestURL()+"";
        System.out.println("请求地址"+url);
        String jsapiTicket = JsapiTicketUtil.getJSApiTicket();
        Map<String,String> map = WeixinUtils.sign(jsapiTicket,  url);
        request.setAttribute("timestamp", map.get("timestamp"));
        request.setAttribute("nonceStr", map.get("nonceStr"));
        request.setAttribute("signature", map.get("signature"));
        request.setAttribute("appId", "wx53f704e68305cde5");
        return new ModelAndView("user/lists");
    }


    @RequestMapping(value="/wodeshunfengp")//对应“我”
    public ModelAndView wxJsSdkConfig2(HttpServletRequest request, HttpServletResponse response){
        String url = request.getRequestURL()+"";
        System.out.println("请求地址"+url);
        String jsapiTicket = JsapiTicketUtil.getJSApiTicket();
        Map<String,String> map = WeixinUtils.sign(jsapiTicket,  url);
        request.setAttribute("timestamp", map.get("timestamp"));
        request.setAttribute("nonceStr", map.get("nonceStr"));
        request.setAttribute("signature", map.get("signature"));
        request.setAttribute("appId", "wx53f704e68305cde5");
        return new ModelAndView("user/wodeshunfeng");
    }
    @RequestMapping(value="/fuwuchaxunp")
    public ModelAndView wxJsSdkConfigs(HttpServletRequest request, HttpServletResponse response){
        String url = request.getRequestURL()+"";
        System.out.println("请求地址"+url);
        String jsapiTicket = JsapiTicketUtil.getJSApiTicket();
        Map<String,String> map = WeixinUtils.sign(jsapiTicket,  url);
        request.setAttribute("timestamp", map.get("timestamp"));
        request.setAttribute("nonceStr", map.get("nonceStr"));
        request.setAttribute("signature", map.get("signature"));
        request.setAttribute("appId", "wx53f704e68305cde5");
        return new ModelAndView("user/fuwuchaxun");
    }

    @RequestMapping("/xiadanssp")
    public String xiaDans(Model model) {
        List<Addr> addr = addrService.getAddrList();
        model.addAttribute("addr",addr);
        return "user/xiadan";
    }

    @RequestMapping(value="/xiadansp")
    public ModelAndView xiaDans(HttpServletRequest request, HttpServletResponse response,Model model){
        List<Addr> addrs = addrService.getAddrList();
        model.addAttribute("addrs",addrs);
        String url = request.getRequestURL()+"";
        System.out.println("请求地址"+url);
        String jsapiTicket = JsapiTicketUtil.getJSApiTicket();
        Map<String,String> map = WeixinUtils.sign(jsapiTicket,  url);
        request.setAttribute("timestamp", map.get("timestamp"));
        request.setAttribute("nonceStr", map.get("nonceStr"));
        request.setAttribute("signature", map.get("signature"));
        request.setAttribute("appId", "wx53f704e68305cde5");
        return new ModelAndView("user/xiadan");
    }

    @RequestMapping(value="/diaoyongp")
    public ModelAndView xiaDanss(HttpServletRequest request, HttpServletResponse response,Model model){
        List<Addr> addrs = addrService.getAddrList();
        model.addAttribute("addrs",addrs);
        String url = request.getRequestURL()+"";
        System.out.println("请求地址"+url);
        String jsapiTicket = JsapiTicketUtil.getJSApiTicket();
        Map<String,String> map = WeixinUtils.sign(jsapiTicket,  url);
        request.setAttribute("timestamp", map.get("timestamp"));
        request.setAttribute("nonceStr", map.get("nonceStr"));
        request.setAttribute("signature", map.get("signature"));
        request.setAttribute("appId", "wx53f704e68305cde5");
        return new ModelAndView("user/diaoyong");
    }
    @RequestMapping(value="/jijianrenp")
    public ModelAndView jijianren(HttpServletRequest request, HttpServletResponse response,Model model){
        List<Addr> addrs = addrService.getAddrList();
        model.addAttribute("addrs",addrs);
        String url = request.getRequestURL()+"";
        System.out.println("请求地址"+url);
        String jsapiTicket = JsapiTicketUtil.getJSApiTicket();
        Map<String,String> map = WeixinUtils.sign(jsapiTicket,  url);
        request.setAttribute("timestamp", map.get("timestamp"));
        request.setAttribute("nonceStr", map.get("nonceStr"));
        request.setAttribute("signature", map.get("signature"));
        request.setAttribute("appId", "wx53f704e68305cde5");
        return new ModelAndView("user/jijianren");
    }
    @RequestMapping(value="/shoujianrenp")
    public ModelAndView shoujianren(HttpServletRequest request, HttpServletResponse response,Model model){
        List<Addr> addrs = addrService.getAddrList();
        model.addAttribute("addrs",addrs);
        String url = request.getRequestURL()+"";
        System.out.println("请求地址"+url);
        String jsapiTicket = JsapiTicketUtil.getJSApiTicket();
        Map<String,String> map = WeixinUtils.sign(jsapiTicket,  url);
        request.setAttribute("timestamp", map.get("timestamp"));
        request.setAttribute("nonceStr", map.get("nonceStr"));
        request.setAttribute("signature", map.get("signature"));
        request.setAttribute("appId", "wx53f704e68305cde5");
        return new ModelAndView("user/shoujianren");
    }

    @RequestMapping(value="/dizhibup1")
    public ModelAndView dizhibup1(HttpServletRequest request, HttpServletResponse response,Model model){
        List<Addr> addrs = addrService.getAddrList();
        model.addAttribute("addrs",addrs);
        String url = request.getRequestURL()+"";
        System.out.println("请求地址"+url);
        String jsapiTicket = JsapiTicketUtil.getJSApiTicket();
        Map<String,String> map = WeixinUtils.sign(jsapiTicket,  url);
        request.setAttribute("timestamp", map.get("timestamp"));
        request.setAttribute("nonceStr", map.get("nonceStr"));
        request.setAttribute("signature", map.get("signature"));
        request.setAttribute("appId", "wx53f704e68305cde5");
        return new ModelAndView("user/dizhibu1");
    }

    @RequestMapping(value="/dizhibup2")
    public String dizhibup2_2(Model model,//default
        @RequestParam(value = "openId",required = false,defaultValue = "345")String openid){
        System.out.println(openid+123);
//        List<Addr> addrs = addrService.getAddrList();
//        List<Addr> addrs = addrRepository.findAll();
        List<Addr> addrs = addrRepository.findByOpenId(openid);
        System.out.println(openid+456);
        model.addAttribute("addrs",addrs);
        System.out.println(openid+789);
        return "user/dizhibu2";
    }
    @RequestMapping(value="/dizhibup2_1")//,defaultValue = "#{weiXinUser?.openId}"
    public ModelAndView dizhibup2(@RequestParam(value = "openId",required = true)String openid,
                                  HttpServletRequest request, HttpServletResponse response,Model model){
//        List<Addr> addrs = addrService.getAddrList();
        System.out.println(openid+123);
        List<Addr> addrs = addrRepository.findByOpenId(openid);
        System.out.println(openid+456);
        model.addAttribute("addrs",addrs);
        System.out.println(openid+789);
//        String url = request.getRequestURL()+"";
//        System.out.println("请求地址"+url);
//        String jsapiTicket = JsapiTicketUtil.getJSApiTicket();
//        Map<String,String> map = WeixinUtils.sign(jsapiTicket,  url);
//        request.setAttribute("timestamp", map.get("timestamp"));
//        request.setAttribute("nonceStr", map.get("nonceStr"));
//        request.setAttribute("signature", map.get("signature"));
//        request.setAttribute("appId", "wx53f704e68305cde5");
        return new ModelAndView("user/dizhibu2");
    }



    @RequestMapping(value="/dizhibupp")
    public ModelAndView dizhibus(HttpServletRequest request, HttpServletResponse response,Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("addrs",users);
        String url = request.getRequestURL()+"";
        System.out.println("请求地址"+url);
        String jsapiTicket = JsapiTicketUtil.getJSApiTicket();
        Map<String,String> map = WeixinUtils.sign(jsapiTicket,  url);
        request.setAttribute("timestamp", map.get("timestamp"));
        request.setAttribute("nonceStr", map.get("nonceStr"));
        request.setAttribute("signature", map.get("signature"));
        request.setAttribute("appId", "wx53f704e68305cde5");
        return new ModelAndView("user/dizhibu");
    }

    @RequestMapping("/userAddp")
    public String userAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/pickerp")
    public String picker() {
        return "user/picker";
    }

    @RequestMapping("/p")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("/lists2p")
    public String list(Model model) {
        List<Addr> addrs=addrService.getAddrList();
        model.addAttribute("addrs", addrs);
        return "user/lists";
    }

    @RequestMapping("/toAddp")
    public String toAdd() {
        return "user/userAdd";
    }
    //////////////////////////
    @RequestMapping("/addp1")
    public String add(Addr addr) {
        addrService.save(addr);
        return "redirect:/xiadan";
//        return "redirect:/dizhibupq1";
    }

    @RequestMapping("/addp2")
    public String add2(Addr addr) {
        addrService.save(addr);
        return "redirect:/xiadan2";
//        return "redirect:/dizhibupq2";
    }

    @RequestMapping("/toEditp")
    public String toEdit(Model model,Long id) {
        Addr addrs=addrService.findAddrById(id);
        model.addAttribute("addrs", addrs);
        return "user/addrEdit";
    }

    @RequestMapping("/editp")
    public String edit(Addr addr) {
        addrService.edit(addr);
        return "redirect:/xiadan";
    }

    @RequestMapping("/toUse")
    public String toUse(Model model,Long id) {
        Addr addrs=addrService.findAddrById(id);
        model.addAttribute("addrs", addrs);
        return "user/xiadan";
    }

    @RequestMapping("/toUse2")
    public String toUse2(Model model,Long id) {
        Addr addrs2=addrService.findAddrById(id);
        model.addAttribute("addrs2", addrs2);
        return "user/xiadan";
    }

    @RequestMapping("/deletep")
    public String delete(Long id) {
        addrService.delete(id);
        return "redirect:/xiadan";
    }

//    @RequestMapping("select")
//    public String select(String danHao,Model model){
//        User result = addrService.findUserByDanHao(danHao);
//        model.addAttribute("result",result);
//        return "user/selectResult";
//    }



}
