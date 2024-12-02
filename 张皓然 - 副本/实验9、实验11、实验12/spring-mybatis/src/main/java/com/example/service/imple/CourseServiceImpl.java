package com.example.service.imple;

import com.example.dao.CourseMapper;
import com.example.entity.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.listCourses();
    }

    @Override
    public List<Course> listCoursesByParams(Map<String, Object> params) {
        return courseMapper.listCoursesByParams(params);
    }

    public Integer addCourse(Course Course) {
        courseMapper.insertCourse(Course);
        return Course.getId();
    }

    public Integer updateCourse(Course Course) {
        courseMapper.updateCourse(Course);
        return Course.getId();
    }

    public Integer deleteCourse(int id) {
        courseMapper.deleteCourseById(id);
        return id;
    }

    public void deleteCourses(List<String> ids) {
        courseMapper.deleteCourses(ids);
       // return id;
    }

    public Course getCourseById(int id) {
        return courseMapper.getCourseById(id);
    }
}