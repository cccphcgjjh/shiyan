package com.example.service;

import com.example.entity.Student;
import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> getAllStudents();
    List<Student> listStudentsByParams(Map<String, Object> params);
    Student getStudentById(int id);
    Integer addStudent(Student student);
    Integer updateStudent(Student student);
    Integer deleteStudent(int id);
    void deleteStudents(List<String> ids);
}