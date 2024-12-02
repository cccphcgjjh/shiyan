package com.example.controller;

import com.example.config.Utils;
import com.example.entity.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    @GetMapping("/list")
    public List<Course> listCourses(@RequestParam Map<String, Object> params) {
        System.out.println("listCourses by params==="+ params);
        return courseService.listCoursesByParams(params);
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) throws Exception {
        System.out.println("addCourse===");
        Utils.printValues(course);
        courseService.addCourse(course);
        return course;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        System.out.println("deleteCourse by id==="+ id);
        courseService.deleteCourse(id);
        return "success";
    }

    @PostMapping("/deleteByIds")
    public String deleteCoursesByIds(@RequestBody List<String> ids) {
        System.out.println("deleteCourses by ids==="+ ids);
        courseService.deleteCourses(ids);
        return "success";
    }

    @PostMapping("/update")
    public String updateCourse(@RequestBody Course course) throws Exception {
        Utils.printValues(course);
        courseService.updateCourse(course);
        return "success";
    }
}