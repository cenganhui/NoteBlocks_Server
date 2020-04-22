package com.example.demo.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ShareNote {
    private Integer sn_id;
    private String u_name;
    private Timestamp sn_times;
    private String sn_title;
    private String sn_content;
    private String sn_audioPath;
    private String sn_picturePath;
    ArrayList<String> sn_picturePathArr = new ArrayList<String>(); //存放分割好的图片路径
    ArrayList<String> sn_audioPathArr = new ArrayList<String>();  //存放分割好的音频路径

    public ShareNote() {
        super();
    }

    public ShareNote(Integer id, String name, Timestamp times, String title, String content, String audioPath, String picturePath) {
        this.sn_id = id;
        this.u_name = name;
        this.sn_times = times;
        this.sn_title = title;
        this.sn_content = content;
        this.sn_audioPath = audioPath;
        this.sn_picturePath = picturePath;
    }

    public ShareNote(Integer id) {
        this.sn_id = id;
        this.u_name = "";
        this.sn_times = null;
        this.sn_title = "";
        this.sn_content = "";
        this.sn_audioPath = "";
        this.sn_picturePath = "";
    }
    /*
        对音频路径进行分割，分别存入audioPathArr中
     */

    public void cutAudioPathArr() {
        sn_audioPathArr = new ArrayList<>();
        String singleAudioPath = "";
        String oldAudioPath = sn_audioPath;
        //去掉?
        int begin = 0, end = 0;
        boolean flag;
        for (int i = 0; i < oldAudioPath.length(); i++) {
            flag = true;
            if (oldAudioPath.charAt(i) == '?') {
                end = i;
                singleAudioPath = oldAudioPath.substring(begin, end);
                for (int j = 0; j < sn_audioPathArr.size(); j++) {
                    if (singleAudioPath.equals(sn_audioPathArr.get(j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sn_audioPathArr.add(singleAudioPath);
                }
                //System.out.println(audioPath);
                begin = end + 1;
            }
        }
    }


    /*
        对图片路径进行分割，分别存入picturePathArr中
     */
    public void cutPicturePath() {
        //picturePathArr = new ArrayList<>();
        String singlePicturePath = "";
        String oldPicturePath = sn_picturePath;
        //去掉?
        int begin = 0, end = 0;
        boolean flag;
        for (int i = 0; i < oldPicturePath.length(); i++) {
            flag = true;
            if (oldPicturePath.charAt(i) == '?') {
                end = i;
                singlePicturePath = oldPicturePath.substring(begin, end);
                for (int j = 0; j < sn_picturePathArr.size(); j++) {
                    if (singlePicturePath.equals(sn_picturePathArr.get(j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sn_picturePathArr.add(singlePicturePath);
                }
                begin = end + 1;
            }
        }
    }

    /*
        获取分割好的音频路径数组audioPathArr
     */
    public ArrayList<String> getAudioPathArr() {
        return sn_audioPathArr;
    }

    /*
        获取分割好的图片路径数组picturePathArr
     */
    public ArrayList<String> getPicturePathArr() {
        return sn_picturePathArr;
    }

    public Integer getSn_id() {
        return sn_id;
    }

    public void setSn_id(Integer sn_id) {
        this.sn_id = sn_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public Timestamp getSn_times() {
        return sn_times;
    }

    public void setSn_times(Timestamp sn_times) {
        this.sn_times = sn_times;
    }

    public String getSn_title() {
        return sn_title;
    }

    public void setSn_title(String sn_title) {
        this.sn_title = sn_title;
    }

    public String getSn_content() {
        return sn_content;
    }

    public void setSn_content(String sn_content) {
        this.sn_content = sn_content;
    }

    public String getSn_audioPath() {
        return sn_audioPath;
    }

    public void setSn_audioPath(String sn_audioPath) {
        this.sn_audioPath = sn_audioPath;
    }

    public String getSn_picturePath() {
        return sn_picturePath;
    }

    public void setSn_picturePath(String sn_picturePath) {
        this.sn_picturePath = sn_picturePath;
    }

    @Override
    public String toString() {
        return "ShareNote{" +
                "sn_id=" + sn_id +
                ", u_name='" + u_name + '\'' +
                ", sn_times=" + sn_times +
                ", sn_title='" + sn_title + '\'' +
                ", sn_content='" + sn_content + '\'' +
                ", sn_audioPath='" + sn_audioPath + '\'' +
                ", sn_picturePath='" + sn_picturePath + '\'' +
                '}';
    }
}
