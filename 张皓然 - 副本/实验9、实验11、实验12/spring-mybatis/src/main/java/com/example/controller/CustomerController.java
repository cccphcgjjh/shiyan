package com.example.controller;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import com.example.config.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/list")
    public List<Customer> listCustomers(@RequestParam Map<String, Object> params) {
        System.out.println("listCustomers by params===" + params);
        return customerService.listCustomersByParams(params);
    }

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) throws Exception {
        System.out.println("addCustomer===");
        Utils.printValues(customer);
        customerService.addCustomer(customer);
        return customer;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        System.out.println("deleteCustomer by id===" + id);
        customerService.deleteCustomer(id);
        return "success";
    }

    @PostMapping("/deleteByIds")
    public String deleteCustomersByIds(@RequestBody List<String> ids) {
        System.out.println("deleteCustomers by ids===" + ids);
        customerService.deleteCustomers(ids);
        return "success";
    }

    @PostMapping("/update")
    public String updateCustomer(@RequestBody Customer customer) throws Exception {
        Utils.printValues(customer);
        customerService.updateCustomer(customer);
        return "success";
    }
}
