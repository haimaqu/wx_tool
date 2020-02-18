package com.imooc.wx_tool.service;


import com.imooc.wx_tool.entity.Addr;
import com.imooc.wx_tool.entity.User;

import java.util.List;

public interface AddrService {

    public List<Addr> getAddrList();

    public Addr findAddrById(long id);

    public void save(Addr addr);

    public void edit(Addr addr);

    public void delete(long id);

//    public User findAddrByDanHao(String danHao);
    public Addr findTopByOrderByIdDesc();

}
