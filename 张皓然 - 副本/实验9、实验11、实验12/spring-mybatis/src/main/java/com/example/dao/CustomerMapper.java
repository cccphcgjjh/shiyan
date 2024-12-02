package com.example.dao;

import com.example.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {

    List<Customer> listCustomers();

    List<Customer> listCustomersByParams(Map<String, Object> params);

    void insertCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomerById(Integer id);

    Customer getCustomerById(Integer id);

    void deleteCustomers(List<String> ids);
}
