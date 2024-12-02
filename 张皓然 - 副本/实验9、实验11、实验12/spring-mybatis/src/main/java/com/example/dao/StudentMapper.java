package com.example.dao;

import com.example.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> listStudents();
    List<Student> listStudentsByParams(Map<String, Object> params);
    void insertStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(Integer id);
    Student getStudentById(Integer id);

    void deleteStudents(List<String> ids);
}