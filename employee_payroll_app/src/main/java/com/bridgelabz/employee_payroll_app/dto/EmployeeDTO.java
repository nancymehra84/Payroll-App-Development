package com.bridgelabz.employee_payroll_app.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String name;
    private double salary;
    private String role;

    public EmployeeDTO(String name,double salary, String role){
        this.name=name;
        this.salary=salary;
        this.role=role;
    }
    public String getName() {
        return name;
    }

    public String getRole(){
        return role;
    }

    public double getSalary(){
        return salary;
    }
}
