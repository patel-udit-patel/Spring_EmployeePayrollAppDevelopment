package com.example.SpringEmployeePayrollApp.controller;

import com.example.SpringEmployeePayrollApp.model.Employee;
import com.example.SpringEmployeePayrollApp.dto.EmployeeDTO;
import com.example.SpringEmployeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Validated
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

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,@Valid @RequestBody Employee employee) {
        employee.setId(id);
        return service.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }

    @PostMapping("/add")
    public Employee addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        // Map DTO to Entity (Employee) and save to DB (or just process the data)
        Employee employee;
        employee = service.addEmployee(new Employee(employeeDTO.getName(), employeeDTO.getDepartment(), employeeDTO.getSalary()));
        return employee;
//        return "Employee added: " + employeeDTO.getName() + " with salary " + employeeDTO.getSalary();
    }

    @GetMapping("/all")
    public List<Employee> getEmployee() {
        // Retrieve employee details
        return service.getAllEmployees();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        Employee employee = service.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
}
