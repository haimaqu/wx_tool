package com.imooc.wx_tool.repository;

import com.imooc.wx_tool.entity.User;
import com.imooc.wx_tool.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {



}