package com.example.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "employees")
public class Employee {
    @Id
    private Integer employeeId;
    private String employeeUniqueId;
    private String employeeName;
    private String departmentName;
    private Double salary;
    private String email;
}
