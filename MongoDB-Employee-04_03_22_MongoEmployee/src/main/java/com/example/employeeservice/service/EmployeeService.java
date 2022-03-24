package com.example.employeeservice.service;

import com.example.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto findEmployeeByEmployeeUniqueId(String employeeUniqueId);
    public void deleteEmployeeByEmail(String email);
    public List<EmployeeDto> getEmployees();
    public void deleteEmployeeByEmployeeUniqueId(String employeeUniqueid);
}
