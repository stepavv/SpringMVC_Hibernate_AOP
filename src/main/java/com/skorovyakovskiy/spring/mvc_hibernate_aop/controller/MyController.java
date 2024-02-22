package com.skorovyakovskiy.spring.mvc_hibernate_aop.controller;

import com.skorovyakovskiy.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.skorovyakovskiy.spring.mvc_hibernate_aop.dao.EmployeeDAOImpl;
import com.skorovyakovskiy.spring.mvc_hibernate_aop.entity.Employee;
import com.skorovyakovskiy.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee")
    public String showEmployees(Model model) {
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("emps", employees);
        return "employees";
    }

    @RequestMapping("/employee/add")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/employee/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @RequestMapping("/employee/update")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/employee/delete")
    public String deleteEmployee(@RequestParam("empId") int id, Model model) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }

}
