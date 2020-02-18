package com.imooc.wx_tool.service;

import com.imooc.wx_tool.entity.Custom;
import com.imooc.wx_tool.repository.CustomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Repository
public class CustomService {

    @Autowired
    private CustomRepository customRepository;
    public boolean verifyCustom(Custom custom) {

        if (customRepository.findByUsernameAndPassword(custom.getUsername(), custom.getPassword()).isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    public String registerCustom(Custom custom) {
        if (customRepository.findByUsername(custom.getUsername()).isEmpty()) {
            customRepository.save(custom);
            //return "用户名  " + custom.getUsername() + " 注册成功";
            return "redirect:login";

        } else {

            return "用户名 " + custom.getUsername() + "已被占用！";
        }

    }



}
