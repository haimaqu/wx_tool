package com.imooc.wx_tool.pojo;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private String scope;//范围
    private String updateTime;
     //  private String scope;
     //  private String name;
     //  private String hotSong;
    private List<HotSinger> hotSingerList = new ArrayList<>();

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<HotSinger> getHotSingerList() {
        return hotSingerList;
    }

    public void setHotSingerList(List<HotSinger> hotSingerList) {
        this.hotSingerList = hotSingerList;
    }
}

