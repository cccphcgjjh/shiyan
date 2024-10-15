package com.lyrpx.mapper;

import com.lyrpx.pojo.Employee;

import java.util.List;
public interface EmployeeMapper {
        List<Employee> selectAll();
        Employee selectById(int id);
        int add(Employee employee);
        int update(Employee employee);
        int delete(int id);



}
