package com.bridgelabz.employee_payroll_app.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@Data
public class EmployeeDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]{2,}$", message = "Name should start with an uppercase letter and have at least 3 characters")

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
