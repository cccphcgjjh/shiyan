package com.example.entity;

import lombok.Data;

@Data
public class Customer {
    /**
     * 客户ID
     */
    private Integer customerId;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户性别
     */
    private String customerGender;

    /**
     * 客户年龄
     */
    private Integer customerAge;

    /**
     * 客户手机号
     */
    private String customerPhone;

    /**
     * 客户邮箱
     */
    private String customerEmail;

    /**
     * 客户地址
     */
    private String customerAddress;
}
