package com.example.service;

import com.example.entity.Customer;
import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Customer> getAllCustomers();

    List<Customer> listCustomersByParams(Map<String, Object> params);

    Integer addCustomer(Customer customer);

    Integer updateCustomer(Customer customer);

    Integer deleteCustomer(int id);

    void deleteCustomers(List<String> ids);

    Customer getCustomerById(int id);
}
