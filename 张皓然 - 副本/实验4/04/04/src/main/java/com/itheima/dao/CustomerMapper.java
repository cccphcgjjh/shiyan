package com.itheima.dao;

import com.itheima.pojo.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {

    // 插入一条新的记录
    @Insert("INSERT INTO customers(username, jobs, phone) VALUES(#{username}, #{jobs}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertCustomer(Customer customer);

    // 根据 ID 删除记录
    @Delete("DELETE FROM customers WHERE id = #{id}")
    int deleteCustomerById(Integer id);

    // 更新记录
    @Update("UPDATE customers SET username=#{username}, jobs=#{jobs}, phone=#{phone} WHERE id=#{id}")
    int updateCustomer(Customer customer);

    // 根据 ID 查询记录
    @Select("SELECT * FROM customers WHERE id = #{id}")
    Customer selectCustomerById(Integer id);

    // 查询所有记录
    @Select("SELECT * FROM customers")
    List<Customer> selectAllCustomers();
}