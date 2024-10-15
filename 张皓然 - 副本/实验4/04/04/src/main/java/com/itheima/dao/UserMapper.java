package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    // 插入一条新的记录
    @Insert("INSERT INTO users(uname, uage) VALUES(#{uname}, #{uage})")
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    int insertUser(User user);

    // 根据 ID 删除记录
    @Delete("DELETE FROM users WHERE uid = #{uid}")
    int deleteUserById(int uid);

    // 更新记录
    @Update("UPDATE users SET uname=#{uname}, uage=#{uage} WHERE uid=#{uid}")
    int updateUser(User user);

    // 根据 ID 查询记录
    @Select("SELECT * FROM users WHERE uid = #{uid}")
    User selectUserById(int uid);

    // 查询所有记录
    @Select("SELECT * FROM users")
    List<User> selectAllUsers();
}