package com.example.demo.dao;

import com.example.demo.mapper.DatabaseMapper;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class UserDao {
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
    private static UserMapper userDB = session.getMapper(UserMapper.class);

    /**
     *
     */
    public static void createTable() {
        if (userDB.isTableExist() >= 1) {
            System.out.println("UserDao:creatTable -- " + "表已存在，创建完成。");
        } else {
            System.out.println("UserDao:creatTable -- " + "尚未初始化表，正在创建。");
            userDB.createTable();
        }

    }

    /**
     * 比对密码是否正确
     *
     * @param name
     * @param passwd
     * @return 是否正确
     */
    public static boolean comparPasswd(String name, String passwd) {
        boolean passwdTrue = false;
        System.out.println("UserDao:comparPasswd --" + "name:" + name + ",passwd:" + passwd);
        String truePasswd = userDB.getPasswd(name);
        if (truePasswd != null && truePasswd.equals(passwd)) {
            passwdTrue = true;
        }
        return passwdTrue;
    }

    /**
     * 创建新用户
     *
     * @param name   用户名
     * @param passwd 密码
     */
    public static boolean createNewUser(String name, String passwd) {
        boolean success = false;
        Map map = new HashMap();
        map.put("u_name", name);
        map.put("u_passwd", passwd);
        userDB.addUser(map);
        session.commit();
        success = true;
        return success;
    }

    /**
     * 在comparPasswd密码确认后可以调用此方法更改密码
     *
     * @param name      用户名
     * @param newPasswd 新密码
     * @return
     */
    public static boolean changePasswd(String name, String newPasswd) {
        boolean success = false;
        Map map = new HashMap();
        map.put("u_name", name);
        map.put("newPasswd", newPasswd);
        userDB.setPasswd(map);
        session.commit();
        success = true;
        return success;
    }
}
