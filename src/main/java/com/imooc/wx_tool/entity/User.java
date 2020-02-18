package com.imooc.wx_tool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String danHao;

    @Column(nullable = false)
    private String fuserName;
    @Column(nullable = false)
    private String tuserName;
    @Column(nullable = false)
    private String fphone;
    @Column(nullable = false)
    private String tphone;
    @Column(nullable = false)
    private String fcity;
    @Column(nullable = false)
    private String tcity;
//    @Column(nullable = false)
//    private int price;
//    @Column(nullable = true)
//    private String picture;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFuserName() {
        return fuserName;
    }

    public void setFuserName(String fuserName) {
        this.fuserName = fuserName;
    }

    public String getTuserName() {
        return tuserName;
    }

    public void setTuserName(String tuserName) {
        this.tuserName = tuserName;
    }

    public String getFphone() {
        return fphone;
    }

    public void setFphone(String fphone) {
        this.fphone = fphone;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getFcity() {
        return fcity;
    }

    public void setFcity(String fcity) {
        this.fcity = fcity;
    }

    public String getTcity() {
        return tcity;
    }

    public void setTcity(String tcity) {
        this.tcity = tcity;
    }

//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public String getPicture() {
//        return picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }

    public String getDanHao() {
        return danHao;
    }

    public void setDanHao(String danHao) {
        this.danHao = danHao;
    }
}
