package com.bridgelabz.employee_payroll_app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class EmployeeDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]{2,}$", message = "Name should start with an uppercase letter and have at least 3 characters")

    private String name;

    @Min(value = 1000, message = "Salary must be greater than 1000")
    private double salary;

    @NotEmpty(message = "Role cannot be empty")
    private String role;

    @NotEmpty(message = "Gender cannot be empty")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender should be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Start Date cannot be null")
    @PastOrPresent(message = "Start Date should be in the past or present")
    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be blank")
    private String note;

    @NotBlank(message = "Profile Picture URL cannot be blank")
    private String profilePic;

    @NotEmpty(message = "Department cannot be empty")
    private List<String> department;

    public EmployeeDTO(String name, double salary, String role, String gender, LocalDate startDate, String note, String profilePic, List<String> department){
        this.name=name;
        this.salary=salary;
        this.role=role;
    }
    public String getName() {
        return name;
    }
    @NotBlank(message = "Note cannot be blank")
    public String getRole(){
        return role;
    }

    public double getSalary(){
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getDepartment() {
        return department;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getNote() {
        return note;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
