package com.imooc.wx_tool.service;


import com.imooc.wx_tool.entity.User;
import com.imooc.wx_tool.entity.Users;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public User save(User user);

    public void edit(User user);

    public void delete(long id);

    public User findUserByDanHao(String danHao);
    public User findTopByOrderByIdDesc();
    //public Users save(Users users);
}
