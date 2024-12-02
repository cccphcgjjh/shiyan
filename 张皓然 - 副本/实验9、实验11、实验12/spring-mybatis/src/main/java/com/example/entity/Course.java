package com.example.entity;

import lombok.Data;

/**
 * 课程实体类，用于表示课程的相关信息
 */
@Data
public class Course {
    /**
     * 课程ID
     */
    private Integer id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程类别
     */
    private String courseCategory; // 课程类别

    /**
     * 课程周期
     */
    private Integer coursePeriod; // 课程周期

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 获取课程ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置课程ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取课程名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置课程名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取课程类别
     */
    public String getCourseCategory() {
        return courseCategory;
    }

    /**
     * 设置课程类别
     */
    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    /**
     * 获取课程周期
     */
    public Integer getCoursePeriod() {
        return coursePeriod;
    }

    /**
     * 设置课程周期
     */
    public void setCoursePeriod(Integer coursePeriod) {
        this.coursePeriod = coursePeriod;
    }

    /**
     * 获取备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
