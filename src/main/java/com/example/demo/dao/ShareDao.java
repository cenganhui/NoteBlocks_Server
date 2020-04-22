package com.example.demo.dao;

import com.example.demo.dao.DbDao;
import com.example.demo.mapper.DatabaseMapper;
import com.example.demo.mapper.ShareNotesMapper;
import com.example.demo.model.Note;
import com.example.demo.model.ShareNote;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;

//数据集合以及数据操作类
public class ShareDao {
    // mybatis 相关
    private static String resource = "config/mybatis-config.xml";
    private static InputStream inputStream;

    static {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    private static SqlSession session = sqlSessionFactory.openSession();
    private static ShareNotesMapper snDB = session.getMapper(ShareNotesMapper.class);
    private static ArrayList<ShareNote> allNotes = new ArrayList<ShareNote>();

    /**
     * 创建表。（当表不存在才创建，表存在时不创建）
     */
    public static void creatTable() {
        if (snDB.isTableExist() >= 1) {
            System.out.println("ShareDao:creatTable -- " + "表已存在，创建完成。");
        } else {
            System.out.println("ShareDao:creatTable -- " + "尚未初始化表，正在创建。");
            snDB.createTable();
            session.commit();//开启了jdbc事务，需要提交生效
            System.out.println("ShareDao:creatTable -- " + "创建完成。");
        }
        reloadNotes();
    }

    /**
     * 重新加载array数组
     */
    public static void reloadNotes() {
        allNotes = snDB.getDatas();
    }

    /**
     * 返回全局的数据集合，需要参数:
     *
     * @return ArrayList<Note>，存有所有的数据
     */
    public static ArrayList<ShareNote> getAllNotes() {

        return allNotes;
    }

    /**
     * 往数据集合中添加数据。
     *
     * @param newShareNote 1. 一个数据模型的实例
     * @return int数据在数据库中获取的值
     */
    public static int addShareNote(ShareNote newShareNote) {
        System.out.println("ShareDao:addShareNote -- " + newShareNote);
        snDB.addData(newShareNote);
        session.commit();//开启了jdbc事务，需要提交生效
        int currentId = getMaxSnId();
        newShareNote.setSn_id(currentId);
        allNotes.add(newShareNote);
        System.out.println("ShareDao:addShareNote -- " + "添加ShareNote成功，sn_id为：" + currentId);
        return currentId;
    }

    /**
     * 往数据集合中移除数据。
     *
     * @param sn_id
     */
    public static void removeShareNoteBySnId(int sn_id) {
        for (int j = 0; j < allNotes.size(); j++) {
            if (allNotes.get(j).getSn_id() == sn_id) {
                snDB.delDataBySnId(sn_id);
                session.commit();//开启了jdbc事务，需要提交生效
                allNotes.remove(j);
                System.out.println("ShareDao:removeShareNoteBySnId -- " + "成功移除数据");
                break;
            }
        }
    }

    /**
     * 从数据集合中获取数据。
     *
     * @param sn_id
     * @return 返回值：指定sn_id值的数据
     */
    public static ShareNote getShareNoteBySnId(int sn_id) {
        for (int j = 0; j < allNotes.size(); j++) {
            if (allNotes.get(j).getSn_id() == sn_id) {
                System.out.println("ShareDao:getShareNoteBySnId -- " + "成功根据sn_id获得数据");
                return allNotes.get(j);
            }
        }
        //当没有找到对应值的数据时返回一个带错误标识的数据
        return getErrorNode("没有找到对应sn_id的数据");
    }


    /**
     * 从数据集合中修改数据
     *
     * @param newShareNote
     */
    public static void changeShareNote(ShareNote newShareNote) {
        snDB.fullUpdateData(newShareNote);
        session.commit();//开启了jdbc事务，需要提交生效
        for (int j = 0; j < allNotes.size(); j++) {
            if (allNotes.get(j).getSn_id() == newShareNote.getSn_id()) {
                allNotes.set(j, newShareNote);
                System.out.println("ShareDao:changeShareNote -- " + "修改数据成功");
                break;
            }
        }
    }

    /**
     * 返回一个带有错误标识的数据模型。
     *
     * @param errorDes 错误描述
     * @return 带错误标识的Node实例，ids为-1，其余参数全为errorDes
     */
    public static ShareNote getErrorNode(String errorDes) {
        ShareNote errorNote = new ShareNote(-1);
        errorNote.setSn_title(errorDes);
        errorNote.setSn_content(errorDes);
        errorNote.setSn_times(null);
        errorNote.setSn_audioPath(errorDes);
        errorNote.setSn_picturePath(errorDes);
        return errorNote;
    }

    /**
     * 得到当前数据库的最大值。
     *
     * @return 最大的sn_id值
     */
    public static int getMaxSnId() {
        return snDB.getMaxSnId();
    }


}
