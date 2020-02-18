package com.imooc.wx_tool.service;

import com.imooc.wx_tool.entity.Addr;
import com.imooc.wx_tool.entity.User;
import com.imooc.wx_tool.repository.AddrRepository;
import com.imooc.wx_tool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddrServiceImpl implements AddrService {

    @Autowired
    private AddrRepository addrRepository;
    @Override
    public Addr findTopByOrderByIdDesc() {
        return addrRepository.findTopByOrderByIdDesc();
    }
    @Override
    public List<Addr> getAddrList() {
        return addrRepository.findAll();
    }

//    @Override
//    public User findTopByOrderByIdDesc() {
//        return addrRepository.findTopByOrderByIdDesc();
//    }

    @Override
    public Addr findAddrById(long id) {
        return addrRepository.findById(id);
    }

    @Override
    public void save(Addr addr) {
        addrRepository.save(addr);
    }

    @Override
    public void edit(Addr addr) {
        addrRepository.save(addr);
    }

    @Override
    public void delete(long id) {
        addrRepository.delete(id);
        //userRepository.deleteById(id);
    }

//    @Override
//    public User findUserByDanHao(String danHao) {
//        return addrRepository.findByDanHao(danHao);
//    }




}


