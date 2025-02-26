package com.example.SpringEmployeePayrollApp.service;

import com.example.SpringEmployeePayrollApp.dto.EmployeeDTO;
import com.example.SpringEmployeePayrollApp.exception.EmployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import com.example.SpringEmployeePayrollApp.model.Employee;
import com.example.SpringEmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Slf4j  // Lombok annotation for logging
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId((Long) (repository.count() + 1)); // Dummy ID generation
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());

        repository.save(employee);

        log.info("Employee Added: {}", employee); // Logging the new employee
        return employee;
    }

//    public List<Employee> getAllEmployees() {
//        return repository.findAll();
//    }

    public void deleteEmployee(Long id){
        List<Employee>emp=repository.findAll();
        for(int i=0;i< repository.count();i++){
            if((emp.get(i)).getId().equals(id)){
                repository.delete(emp.get(i));
            }
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee>employeeList=new ArrayList<>();
        employeeList=repository.findAll();

        log.info("Fetching all employees. Total: {}", employeeList.size());
        return employeeList;
    }

    public Employee getEmployeeById(Long id) {
        log.info("Fetching Employee with ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}