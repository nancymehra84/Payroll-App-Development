package com.bridgelabz.employee_payroll_app.service;

import com.bridgelabz.employee_payroll_app.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll_app.exception.EmployeeNotFoundException;
import com.bridgelabz.employee_payroll_app.model.Employee;
import com.bridgelabz.employee_payroll_app.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Optional;

//@Slf4j
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    // Convert Employee to EmployeeDTO
    private EmployeeDTO convertToDTO(Employee employee) {
        return new EmployeeDTO(employee.getName(), employee.getSalary(), employee.getRole(),employee.getGender(),
                employee.getStartDate(),
                employee.getNote(),
                employee.getProfilePic(),
                employee.getDepartment());
    }

    // Convert EmployeeDTO to Employee
    private Employee convertToEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setRole(dto.getRole());
        employee.setSalary(dto.getSalary());
        employee.setGender(dto.getGender());
        employee.setStartDate(dto.getStartDate());
        employee.setNote(dto.getNote());
        employee.setProfilePic(dto.getProfilePic());
        employee.setDepartment(dto.getDepartment());
        return employee;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return convertToDTO(employee);
    }

    public EmployeeDTO saveEmployee(EmployeeDTO dto) {
        Employee employee = convertToEntity(dto);
        Employee savedEmployee = repository.save(employee);
        return convertToDTO(savedEmployee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public void DeleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        repository.deleteById(id);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(employeeDTO.getName());
        employee.setRole(employeeDTO.getRole());
        employee.setSalary(employeeDTO.getSalary());

        Employee updatedEmployee = repository.save(employee);
        return convertToDTO(updatedEmployee);
    }

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    public void logExample() {
        log.debug("DEBUG: Employee Service Debugging...");
        log.info("INFO: Employee Service Processing...");
        log.warn("WARN: Employee Service Warning...");
        log.error("ERROR: Employee Service Error...");
    }
    public List<EmployeeDTO> getEmployeesByDepartment(String department) {
        List<Employee> employees = repository.findEmployeesByDepartment(department);
        return employees.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
