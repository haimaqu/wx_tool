package com.imooc.wx_tool.web;


import com.imooc.wx_tool.entity.Custom;
import com.imooc.wx_tool.entity.User;
import com.imooc.wx_tool.service.CustomService;
import com.imooc.wx_tool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class CustomController {
    @Autowired
    private CustomService customService;
    @Resource
    UserService userService;

    @RequestMapping("/notVerify")
    @ResponseBody
    String notVerify() {
        return "username or password NOT correct";
    }

    @RequestMapping("/login")
    String login(Model model) {
        model.addAttribute("user", new Custom());
        return "login";
    }

    @RequestMapping("/register")
    String register(Model model) {
        model.addAttribute("user", new Custom());
        return "register";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    //@ResponseBody
    String registerUser(Custom custom, Model model) {
        return customService.registerCustom(custom);
    }


    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    String userLogin(Custom custom, Model model) {
        boolean verify = customService.verifyCustom(custom);
        if (verify) {
            model.addAttribute("name", custom.getUsername());
            model.addAttribute("password", custom.getPassword());
           // return "result";
            List<User> users=userService.getUserList();
            model.addAttribute("users", users);
            return "user/lists";
        } else {
            return "redirect:/notVerify";
        }

    }



}
