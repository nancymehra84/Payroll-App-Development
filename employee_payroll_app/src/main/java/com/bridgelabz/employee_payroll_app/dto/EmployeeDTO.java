package com.bridgelabz.employee_payroll_app.dto;

import lombok.*;

@Getter
@Setter

public class EmployeeDTO {
    private String name;
    private double salary;
    private String role;

    public EmployeeDTO(String name, double salary, String role) {
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    public EmployeeDTO() {}
    // Getters
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
