package com.example.SpringEmployeePayrollApp.controller;

import com.example.SpringEmployeePayrollApp.model.Employee;
import com.example.SpringEmployeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }
}
