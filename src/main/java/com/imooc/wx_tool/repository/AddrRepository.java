package com.imooc.wx_tool.repository;

import com.imooc.wx_tool.entity.Addr;
import com.imooc.wx_tool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddrRepository extends JpaRepository<Addr, Long> {

    Addr findById(long id);
    /*  User findByUserName(String username);*/
    List<Addr> findByOpenId(String openId);
    //User findByDanHao(String danHao);
    //User findTopByOrderByIdDesc();
    //List<User> findTopByOrderByIdDesc();
    //User findTopByOrderByIdDesc();
    Addr findTopByOrderByIdDesc();
}