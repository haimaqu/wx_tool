package com.imooc.wx_tool.repository;

import com.imooc.wx_tool.entity.User;
 import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);
    /*  User findByUserName(String username);*/

    User findByDanHao(String danHao);
//    User findTopByOrderByIdDesc();
//List<User> findTopByOrderByIdDesc();
    User findTopByOrderByIdDesc();

}