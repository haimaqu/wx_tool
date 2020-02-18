package com.imooc.wx_tool.repository;

 import com.imooc.wx_tool.entity.Custom;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomRepository extends JpaRepository<Custom,Long> {
//    List<Custom> findByUsernameAndPassword(String username,String password);
    /////////////userName --->UserName   username--->Username
    public List<Custom> findByUsername(String username);
    public List<Custom> findByUsernameAndPassword(String username, String password);
    @Query("from Custom c where c.username=:username ")
    public List<Custom>findCustom(@Param("username") String username);





}
