package com.example.demo.model;

import java.util.Date;

/**
 * 商品
 */

public class commodities {
    private String u_id;        //用户id（外键）
    private int c_id;           //商品id
    private String c_name;      //商品名称
    private double c_price;     //价格
    private String c_brief;     //简介
    private Date c_time;        //时间
    private int c_class;        //分类
    private int c_status;       //状态

    public commodities() {
        super();
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public double getC_price() {
        return c_price;
    }

    public void setC_price(double c_price) {
        this.c_price = c_price;
    }

    public String getC_brief() {
        return c_brief;
    }

    public void setC_brief(String c_brief) {
        this.c_brief = c_brief;
    }

    public Date getC_time() {
        return c_time;
    }

    public void setC_time(Date c_time) {
        this.c_time = c_time;
    }

    public int getC_class() {
        return c_class;
    }

    public void setC_class(int c_class) {
        this.c_class = c_class;
    }

    public int getC_status() {
        return c_status;
    }

    public void setC_status(int c_status) {
        this.c_status = c_status;
    }

    @Override
    public String toString() {
        return "users{" +
                "u_id=" + u_id +
                ", c_id='" + c_id + '\'' +
                ", c_name='" + c_name + '\'' +
                "c_price=" + c_price +
                "c_brief=" + c_brief +
                "c_time=" + c_time +
                "c_class=" + c_class +
                "c_status=" + c_status +
                '}';
    }

}
