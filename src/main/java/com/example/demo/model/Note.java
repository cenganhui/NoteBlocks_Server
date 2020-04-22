package com.example.demo.model;

import javax.xml.soap.Node;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

//数据模型类
public class Note {
    private String u_name;
    private Integer n_ids;
    private Timestamp n_times;
    private String n_title;
    private String n_content;
    private String n_audioPath;
    private String n_picturePath;

    public Note() {
        super();
    }

    public Note(String name, Integer ids, Timestamp times, String title, String content, String audioPath, String picturePath) {
        this.u_name = name;
        this.n_ids = ids;
        this.n_times = times;
        this.n_title = title;
        this.n_content = content;
        this.n_audioPath = audioPath;
        this.n_picturePath = picturePath;
    }

    public Note(Integer ids) {
        this.u_name = "";
        this.n_ids = ids;
        this.n_times = null;
        this.n_title = "";
        this.n_content = "";
        this.n_audioPath = "";
        this.n_picturePath = "";
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public Integer getN_ids() {
        return n_ids;
    }

    public void setN_ids(Integer n_ids) {
        this.n_ids = n_ids;
    }

    public Timestamp getN_times() {
        return n_times;
    }

    public void setN_times(Timestamp n_times) {
        this.n_times = n_times;
    }

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    public String getN_content() {
        return n_content;
    }

    public void setN_content(String n_content) {
        this.n_content = n_content;
    }

    public String getN_audioPath() {
        return n_audioPath;
    }

    public void setN_audioPath(String n_audioPath) {
        this.n_audioPath = n_audioPath;
    }

    public String getN_picturePath() {
        return n_picturePath;
    }

    public void setN_picturePath(String n_picturePath) {
        this.n_picturePath = n_picturePath;
    }

    @Override
    public String toString() {
        return "Note{" +
                "u_name='" + u_name + '\'' +
                ", n_ids=" + n_ids +
                ", n_times=" + n_times +
                ", n_title='" + n_title + '\'' +
                ", n_content='" + n_content + '\'' +
                ", n_audioPath='" + n_audioPath + '\'' +
                ", n_picturePath='" + n_picturePath + '\'' +
                '}';
    }
}
