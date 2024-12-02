package com.example.controller;

import com.example.config.Utils;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/list")
    public List<Student> listStudents(@RequestParam Map<String, Object> params) {
        System.out.println("listStudents by params==="+ params);
        return studentService.listStudentsByParams(params);
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) throws Exception {
        System.out.println("addStudent===");
        Utils.printValues(student);
        studentService.addStudent(student);
        return student;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        System.out.println("deleteStudent by id==="+ id);
        studentService.deleteStudent(id);
        return "success";
    }

    @PostMapping("/deleteByIds")
    public String deleteStudentsByIds(@RequestBody List<String> ids) {
        System.out.println("deleteStudents by ids==="+ ids);
        studentService.deleteStudents(ids);
        return "success";
    }

    @PostMapping("/update")
    public String updateStudent(@RequestBody Student student) throws Exception {
        Utils.printValues(student);
        studentService.updateStudent(student);
        return "success";
    }
}