package com.example.demo.model;

public class User {
    private int u_id;
    private String u_name;
    private String u_passwd;

    public User() {
        super();
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
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

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_passwd='" + u_passwd + '\'' +
                '}';
    }
}
