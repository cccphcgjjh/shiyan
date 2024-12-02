package com.example.service.impl;

import com.example.dao.StudentMapper;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.listStudents();
    }

    @Override
    public List<Student> listStudentsByParams(Map<String, Object> params) {
        return studentMapper.listStudentsByParams(params);
    }

    public Integer addStudent(Student student) {
        studentMapper.insertStudent(student);
        return student.getId();
    }

    public Integer updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return student.getId();
    }

    public Integer deleteStudent(int id) {
        studentMapper.deleteStudentById(id);
        return id;
    } public void deleteStudents(List<String> ids) {
        studentMapper.deleteStudents(ids);
       // return id;
    }

    public Student getStudentById(int id) {
        return studentMapper.getStudentById(id);
    }
}