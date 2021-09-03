package com.alexn.spring.rest.controller;


import com.alexn.spring.rest.entity.Employee;
import com.alexn.spring.rest.exception_handling.NoSuchEmployeeException;
import com.alexn.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;

    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee=employeeService.getEmployee(id);

        if(employee==null){
              throw  new NoSuchEmployeeException("There no such employee!");

        }

        return employee;

    }


}
