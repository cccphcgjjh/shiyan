package com.example.dao;

import com.example.entity.Course;
import com.example.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper {
    List<Course> listCourses();
    List<Course> listCoursesByParams(Map<String, Object> params);
    void insertCourse(Course Course);
    void updateCourse(Course Course);
    void deleteCourseById(Integer id);
    Course getCourseById(Integer id);
    void deleteCourses(List<String> ids);
}