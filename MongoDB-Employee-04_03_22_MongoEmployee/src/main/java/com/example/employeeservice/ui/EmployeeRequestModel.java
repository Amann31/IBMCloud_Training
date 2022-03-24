package com.example.employeeservice.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeRequestModel {
    private String employeeName;
    private String departmentName;
    private Double salary;
    private String email;
}
