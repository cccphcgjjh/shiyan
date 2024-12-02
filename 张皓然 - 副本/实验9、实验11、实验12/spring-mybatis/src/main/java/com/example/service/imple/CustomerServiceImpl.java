package com.example.service.imple;

import com.example.dao.CustomerMapper;
import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getAllCustomers() {
        return customerMapper.listCustomers();
    }

    @Override
    public List<Customer> listCustomersByParams(Map<String, Object> params) {
        return customerMapper.listCustomersByParams(params);
    }

    @Override
    public Integer addCustomer(Customer customer) {
        customerMapper.insertCustomer(customer);
        return customer.getCustomerId();
    }

    @Override
    public Integer updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
        return customer.getCustomerId();
    }

    @Override
    public Integer deleteCustomer(int id) {
        customerMapper.deleteCustomerById(id);
        return id;
    }

    @Override
    public void deleteCustomers(List<String> ids) {
        customerMapper.deleteCustomers(ids);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerMapper.getCustomerById(id);
    }
}
