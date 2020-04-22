package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface usersMapper {
    /**
     * 检查是否存在表
     */
    public int isTableExist();

    /**
     * 创建表
     */
    public void createTable();

    /**
     * 根据用户id删除用户
     *
     * @param u_id 需要删除的用户的id
     */
    public void delUserById(@Param("u_id") String u_id);

    /**
     * 通过旧用户id和新的id修改旧用户id
     *
     * @param map 需要包含(u_id , new_id)
     */
    public void setId(Map map);

    /**
     * 通过用户id和新的密码修改旧密码
     *
     * @param map 需要包含(u_id , new_passwd)
     */
    public void setPasswd(Map map);

    /**
     * 通过用户id和密码创建新用户
     *
     * @param map 需要包含(u_id , u_passwd)
     */
    public void addUsers(Map map);

    /**
     * 通过用户id获取密码
     *
     * @param u_id 传入用户id
     */
    public String getPasswd(@Param("u_id") String u_id);

}
