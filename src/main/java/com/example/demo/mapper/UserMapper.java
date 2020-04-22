package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    /**
     * 检查是否存在表
     */
    public int isTableExist();

    /**
     * 创建表
     */
    public void createTable();

    /**
     * 根据用户名称删除用户
     *
     * @param u_name 需要删除的用户的名字
     */
    public void delUserByName(@Param("u_name") String u_name);

    /**
     * 通过旧用户名和新的名称修改旧用户名
     *
     * @param map 需要包含(u_name , newName)
     */
    public void setName(Map map);

    /**
     * 通过用户名和新的密码修改旧密码
     *
     * @param map 需要包含(u_name , newPasswd)
     */
    public void setPasswd(Map map);

    /**
     * 通过用户名和密码创建新用户
     *
     * @param map 需要包含(u_name , u_passwd)
     */
    public void addUser(Map map);

    /**
     * 通过用户名获取密码
     *
     * @param name 传入用户名
     */
    public String getPasswd(@Param("u_name") String name);
}
