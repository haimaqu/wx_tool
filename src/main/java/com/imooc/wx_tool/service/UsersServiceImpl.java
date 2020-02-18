package com.imooc.wx_tool.service;

import com.imooc.wx_tool.entity.Users;
import com.imooc.wx_tool.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users save(Users users) {
        usersRepository.save(users);

        return users;
    }








}


