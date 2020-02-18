package com.imooc.wx_tool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String fuserName;
    @Column(nullable = false)
    private String tuserName;


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

}