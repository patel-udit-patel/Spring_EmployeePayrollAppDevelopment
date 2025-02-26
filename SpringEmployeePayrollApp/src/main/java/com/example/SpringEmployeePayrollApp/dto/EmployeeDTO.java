package com.example.SpringEmployeePayrollApp.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {
    @NotBlank(message = "Name cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z ]{3,50}$", message = "Name must be between 3 to 50 alphabetic characters")
    private String name;
    @NotBlank(message = "Name cannot be empty or null")
    @Pattern(regexp = "^[0-9]{3,10}$", message = "Salary must be between 3 to 10 digit number")
    private Double salary;
    @NotBlank(message = "Name cannot be empty or null")
    @Pattern(regexp = "^[A-Za-z ]{3,50}$", message = "Department must be between 3 to 50 alphabetic characters")
    private String department;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
