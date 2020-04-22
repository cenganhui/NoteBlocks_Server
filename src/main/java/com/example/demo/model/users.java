package com.example.demo.model;

/**
 * 用户
 */


public class users {
    private String u_id;        //学号
    private String u_name;      //姓名
    private String u_passwd;    //密码
    private int u_gender;       //性别
    private String u_avatar;    //头像
    private String u_brief;     //简介
    private int u_campus;       //校区
    private String u_phone;     //电话
    private int u_permission;   //权限

    public users() {
        super();
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_passwd() {
        return u_passwd;
    }

    public void setU_passwd(String u_passwd) {
        this.u_passwd = u_passwd;
    }

    public int getU_gender() {
        return u_gender;
    }

    public void setU_gender(int u_gender) {
        this.u_gender = u_gender;
    }

    public String getU_avatar() {
        return u_avatar;
    }

    public void setU_avatar(String u_avatar) {
        this.u_avatar = u_avatar;
    }

    public String getU_brief() {
        return u_brief;
    }

    public void setU_brief(String u_brief) {
        this.u_brief = u_brief;
    }

    public int getU_campus() {
        return u_campus;
    }

    public void setU_campus(int u_campus) {
        this.u_campus = u_campus;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public int getU_permission() {
        return u_permission;
    }

    public void setU_permission(int u_permission) {
        this.u_permission = u_permission;
    }

    @Override
    public String toString() {
        return "users{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_passwd='" + u_passwd + '\'' +
                "u_gender=" + u_gender +
                "u_avatar=" + u_avatar +
                "u_brief=" + u_brief +
                "u_campus=" + u_campus +
                "u_phone=" + u_phone +
                "u_permission=" + u_permission +
                '}';
    }

}
