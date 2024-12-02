package com.example.entity;

/**
 * 学生实体类，用于表示学生的基本信息。
 */
public class Student {
    /**
     * 学生ID
     */
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生性别
     */
    private String sex;

    /**
     * 学生年龄
     */
    private Integer age;

    /**
     * 备注信息
     */
    private String remark;

    // Getters and Setters

    /**
     * 获取学生ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置学生ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取学生姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学生姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学生性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置学生性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取学生年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置学生年龄
     */
    public void setAge(Integer age) {
        this.age = age;
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
