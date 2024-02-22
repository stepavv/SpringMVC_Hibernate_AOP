package com.skorovyakovskiy.spring.mvc_hibernate_aop.dao;

import com.skorovyakovskiy.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

}
