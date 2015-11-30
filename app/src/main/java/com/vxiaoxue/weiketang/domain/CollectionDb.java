package com.vxiaoxue.weiketang.domain;

/**
 * 我的收藏数据封装类
 * Created by Administrator on 2015/10/22.
 */
public class CollectionDb {
    private int id;
    private String name;
    private String des;
    private String time;

    public CollectionDb() {
    }

    public CollectionDb(int id, String name, String des, String time) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CollectionDb{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
