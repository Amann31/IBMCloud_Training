package com.example.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private String employeeUniqueId;
    private String employeeName;
    private String departmentName;
    private Double salary;
    private String email;
}
