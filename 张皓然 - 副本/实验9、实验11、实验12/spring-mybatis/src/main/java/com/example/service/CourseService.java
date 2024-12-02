package com.example.service;

import com.example.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {
    List<Course> getAllCourses();
    List<Course> listCoursesByParams(Map<String, Object> params);
    Course getCourseById(int id);
    Integer addCourse(Course Course);
    Integer updateCourse(Course Course);
    Integer deleteCourse(int id);
    void deleteCourses(List<String> ids);
}