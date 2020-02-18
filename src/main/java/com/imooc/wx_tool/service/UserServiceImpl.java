package com.imooc.wx_tool.service;

import com.imooc.wx_tool.entity.User;
import com.imooc.wx_tool.entity.Users;
import com.imooc.wx_tool.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findTopByOrderByIdDesc() {
        return userRepository.findTopByOrderByIdDesc();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
        //userRepository.deleteById(id);
    }

    @Override
    public User findUserByDanHao(String danHao) {
        return userRepository.findByDanHao(danHao);
    }




}


