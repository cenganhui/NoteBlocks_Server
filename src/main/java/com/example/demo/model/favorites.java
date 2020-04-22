package com.example.demo.model;

/**
 * 收藏夹
 */

public class favorites {
    private int f_id;       //收藏id
    private String u_id;    //用户id
    private int c_id;       //商品id

    public favorites() {
        super();
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
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

    @Override
    public String toString() {
        return "users{" +
                "f_id=" + f_id +
                ", u_id='" + u_id + '\'' +
                ", c_id='" + c_id + '\'' +
                '}';
    }
}
