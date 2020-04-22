package com.example.demo.utils;

import com.example.demo.api.API;
import com.example.demo.model.Note;
import com.example.demo.model.ShareNote;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class DealHtml {
    /**
     * 返回将Note对象数据放入后的html页面
     *
     * @param shareNote 需要分享的Note对象
     * @return
     */
    public static String putNoteInHtml(ShareNote shareNote) {
        String a = new String();
        shareNote.cutAudioPathArr();
        shareNote.cutPicturePath();
        try {
            Document tmplate = Jsoup.connect(API.fileUrl + "share.html").get();
            Element navBar = tmplate.getElementsByClass("nav_inner_top_left").get(0);
            Element label_user = tmplate.getElementsByClass("user").get(0);
            Element nav_title = navBar.getElementsByClass("title").get(0);
            Element nav_time = navBar.getElementsByClass("time").get(0);
            Element content_time = tmplate.getElementsByClass("text_time").get(0);
            Element content_title = tmplate.getElementsByClass("text_title").get(0);
            Element content_text = tmplate.getElementsByClass("text_content").get(0);
            putStringToElem(label_user, shareNote.getU_name());
            putStringToElem(nav_title, shareNote.getSn_title());
            putStringToElem(nav_time, shareNote.getSn_times().toString().substring(0, 11));
            putStringToElem(content_time, shareNote.getSn_times().toString().substring(0, 11));
            putStringToElem(content_title, shareNote.getSn_title());
            //处理内容文本后放入标签中
            putStringToElem(content_text, dealContentString(shareNote.getSn_content()));
            a = tmplate.toString();
        } catch (IOException e) {
            e.printStackTrace();
            a = "error";
        }
        return a;
    }

    /**
     * 将String放入元素中
     *
     * @param element
     * @param string
     */
    public static void putStringToElem(Element element, String string) {
        if (string == null) {
            element.html("null");
        } else {
            element.html(string);
        }
    }

    public static String dealContentString(String contentString) {
        //处理换行
        contentString = dealBr(contentString);

        //处理音频
        contentString = dealAudioPath(contentString);

        //处理图片
        contentString = dealPicturePath(contentString);

        return contentString;
    }

    /**
     * 替换文本中换行符为网页中的<br>
     *
     * @param content
     * @return
     */
    public static String dealBr(String content) {
        return content.replace("\n", "<br>");
    }

    /**
     * 处理文本中的音频标记
     *
     * @param content
     * @return
     */
    public static String dealAudioPath(String content) {
        StringBuilder stringBuilder = new StringBuilder(content);
        //处理音频
        //<audio src="xxxxxxx" controls="controls" class = "text_audio" >你的浏览器不支持播放音频</audio>
        while (stringBuilder.indexOf("<audio>") != -1) {
            int begin = stringBuilder.indexOf("<audio>");
            int end = begin + 7 + 18;
            int valueBegin = begin + 7;
            int valueEnd = end;
            String value = stringBuilder.substring(valueBegin, valueEnd);
            stringBuilder.replace(begin, end, "<audio src=\"" + API.fileUrl + value + "\" controls=\"controls\" class = \"text_audio\">你的浏览器不支持播放音频" + "</audio>");
        }
        return stringBuilder.toString();
    }

    /**
     * 处理文本中的图片标记
     *
     * @param content
     * @return
     */
    public static String dealPicturePath(String content) {
        //处理图片
        StringBuilder stringBuilder = new StringBuilder(content);
        while (stringBuilder.indexOf("<img>") != -1) {
            int begin = stringBuilder.indexOf("<img>");
            int end = begin + 5 + 18;
            int valueBegin = begin + 5;
            int valueEnd = end;
            String value = stringBuilder.substring(valueBegin, valueEnd);
            stringBuilder.replace(begin, end, "<img src=\"" + API.fileUrl + value + "\" class = \"text_img\" />");
        }
        return stringBuilder.toString();
    }
}
