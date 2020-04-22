package com.example.demo.mapper;

import com.example.demo.model.Note;
import com.example.demo.model.ShareNote;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

public interface ShareNotesMapper {

    /**
     * 无参数
     *
     * @return 查询到的表数量，>=1则说明存在表
     */
    public int isTableExist();

    /**
     * 建表
     */
    public void createTable();

    /**
     * 通过sn_id找到并删除数据
     *
     * @param sn_id
     */
    public void delDataBySnId(@Param("sn_id") int sn_id);

    /**
     * 通过sn_id找到并设置标题
     *
     * @param map 需要包含(sn_id,sn_title)
     */
    public void setTitleBySnId(Map map);

    /**
     * 通过sn_id找到并设置内容
     *
     * @param map 需要包含(sn_id,sn_content)
     */
    public void setContentBySnId(Map map);

    /**
     * 通过sn_id找到并设置时间
     *
     * @param map 需要包含(sn_id,sn_times)
     */
    public void setTimesBySnId(Map map);

    /**
     * 通过sn_id找到并设置音频地址
     *
     * @param map 需要包含(sn_id,sn_audioPath)
     */
    public void setAudioPathBySnId(Map map);

    /**
     * 通过sn_id找到并设置图片地址
     *
     * @param map 需要包含(sn_id,sn_picture)
     */
    public void setPicturePathBySnId(Map map);

    /**
     * 传入一个完整的shareNote对象，更新除了id,u_name外的所有值
     *
     * @param shareNote
     */
    public void fullUpdateData(ShareNote shareNote);

    /**
     * 传入一个完整的ShareNote对象，自动在数据库获取id，将除id外的所有值全部存入数据库
     *
     * @param newShareNote
     */
    public void addData(ShareNote newShareNote);

    /**
     * 根据 sn_id 找到并返回数据
     *
     * @param sn_id
     * @return 完整的Note数据
     */
    public Note searchDataBySnId(@Param("sn_id") int sn_id);

    /**
     * 获得数据库所有数据
     *
     * @return 带有所有数据的ArrayList
     */
    public ArrayList<ShareNote> getDatas();

    /**
     * 获取指定user在数据库中ids的最大值
     *
     * @return
     */
    public int getMaxSnId();

}
