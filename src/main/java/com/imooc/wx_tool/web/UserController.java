package com.imooc.wx_tool.web;

import com.alibaba.fastjson.JSON;
import com.imooc.wx_tool.entity.Addr;
import com.imooc.wx_tool.entity.User;
import com.imooc.wx_tool.entity.Users;
import com.imooc.wx_tool.service.AddrService;
import com.imooc.wx_tool.service.UserService;

import com.imooc.wx_tool.service.UsersService;
import com.imooc.wx_tool.util.JsapiTicketUtil;
import com.imooc.wx_tool.utils.WeixinUtils;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.imooc.wx_tool.controller.WxController.Nonce;
import static com.imooc.wx_tool.controller.WxController.Signature;
import static com.imooc.wx_tool.controller.WxController.Timestamp;

@Controller
public class UserController {

    @Resource

    UserService userService;
    @Resource
    UsersService usersService;
    @Resource
    AddrService addrService;

//    @RequestMapping(value = "/api/search", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @PostMapping("/api/search")
    public String test2(@RequestParam(value = "danHao") String danHao,HttpServletResponse response){
        List<User> list = new ArrayList<>();
        User user = userService.findUserByDanHao(danHao);
        list.add(user);
        String date = JSON.toJSONString(list);
        try {
            sendJsonData(response, date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //下单
    @ResponseBody
    @PostMapping("/api/searchsave")
    public String adda(Users users) {
        usersService.save(users);
        return "redirect:/xiadan";
    }
//    @ResponseBody
//    @PostMapping("/api/usersave")
//    public String usersave(User user) {
//        userService.save(user);
//        return "redirect:/xiadan";
////        return "user/xiadan";
//    }

    //下单
    @ResponseBody
    @PostMapping("/api/usersave")
    public String searchsave(User user,HttpServletResponse response){

        List<User> list = new ArrayList<>();
        User u = userService.save(user);
        list.add(u);
        String date = JSON.toJSONString(list);
        try {
            sendJsonData(response, date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @PostMapping("/api/searchs")
    public String tests(HttpServletResponse response){

        List<User> list = new ArrayList<>();
        User user = userService.findTopByOrderByIdDesc();
        list.add(user);
        String date = JSON.toJSONString(list);
        try {
            sendJsonData(response, date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    @ResponseBody
//    @PostMapping("/api/searchss")
//    private Map<String, Object> getAreaById(Integer areaId) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        User users = userService.findTopByOrderByIdDesc();
//        modelMap.put("users", users);
//        return modelMap;
//    }

    protected void sendJsonData(HttpServletResponse response, String data)
            throws Exception
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(data);
        out.flush();
        out.close();
    }


//    @PostMapping("/api/usersave")
//    @ResponseBody
//    public String jsonArrayAdd(@RequestParam("ids") String ids) {
//
//        JSONObject jsonObject = JSONObject.fromObject(ids);
//        System.out.println("jsonObject==>" + jsonObject);
//        User stu = (User) JSONObject.toBean(jsonObject, User.class);
//        System.out.println("stu==>" + stu);
//        return "成功了!";
//    }

    @RequestMapping(value="/lists")
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


    @RequestMapping(value="/wodeshunfeng")//对应“我”
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
    @RequestMapping(value="/fuwuchaxun")
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
    //////////////////////////可能会用
    @RequestMapping("/dizhibupq1")
    public ModelAndView dizhibupq1(HttpServletRequest request, HttpServletResponse response,Model model){
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
    //////////////////////////可能会用
    @RequestMapping("/dizhibupq2")
    public ModelAndView dizhibupq2(HttpServletRequest request, HttpServletResponse response,Model model){
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
        return new ModelAndView("user/dizhibu2");
    }

    @RequestMapping("/xiadanss")
    public String xiaDans(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
        return "user/xiadan";
    }

    @RequestMapping("xiadan")
    public String xiaDan(Model model){
//        User users = userService.findTopByOrderByIdDesc();
        Addr addr = addrService.findTopByOrderByIdDesc();
//        model.addAttribute("users",addr);
        model.addAttribute("addrs",addr);
//        if(users == null){
//            return "请输入信息";
//        }else {
        return "user/xiadan";
    }
    @RequestMapping("xiadan2")
    public String xiaDan2(Model model){
        Addr addr = addrService.findTopByOrderByIdDesc();
        model.addAttribute("addrs2",addr);
        return "user/xiadan";
    }


    @RequestMapping(value="/xiadans")
    public ModelAndView xiaDans(HttpServletRequest request, HttpServletResponse response,Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
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

    @RequestMapping(value="/diaoyong")
    public ModelAndView xiaDanss(HttpServletRequest request, HttpServletResponse response,Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
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
    @RequestMapping(value="/jijianren")
    public ModelAndView jijianren(HttpServletRequest request, HttpServletResponse response,Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
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
    @RequestMapping(value="/shoujianren")
    public ModelAndView shoujianren(HttpServletRequest request, HttpServletResponse response,Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
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

    @RequestMapping(value="/dizhibu")
    public ModelAndView dizhibu(HttpServletRequest request, HttpServletResponse response,Model model){
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

    @RequestMapping("/userAdd")
    public String userAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/picker")
    public String picker() {
        return "user/picker";
    }


//
//    @RequestMapping("/lists")
//    public String lists(HttpServletRequest request){
//        request.setAttribute("Signature",Signature);
//        request.setAttribute("Timestamp",Timestamp);
//        request.setAttribute("Nonce",Nonce);
//        return "user/lists";
//    }


    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("/lists2")
    public String list(Model model) {
        List<User> users=userService.getUserList();
        model.addAttribute("users", users);
        return "user/lists";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/lists";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        User user=userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/lists";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/lists";
    }

    @RequestMapping("select")
    public String select(String danHao,Model model){
        User result = userService.findUserByDanHao(danHao);
        model.addAttribute("result",result);
        return "user/selectResult";
    }



}
