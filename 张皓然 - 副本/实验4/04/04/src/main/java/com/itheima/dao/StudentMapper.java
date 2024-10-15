package com.itheima.dao;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    // 插入一条新的记录
    @Insert("INSERT INTO students(name, age) VALUES(#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertStudent(Student student);

    // 根据 ID 删除记录
    @Delete("DELETE FROM students WHERE id = #{id}")
    int deleteStudentById(Integer id);

    // 更新记录
    @Update("UPDATE students SET name=#{name}, age=#{age} WHERE id=#{id}")
    int updateStudent(Student student);

    // 根据 ID 查询记录
    @Select("SELECT * FROM students WHERE id = #{id}")
    Student selectStudentById(Integer id);

    // 查询所有记录
    @Select("SELECT * FROM students")
    List<Student> selectAllStudents();
}