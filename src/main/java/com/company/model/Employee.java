package com.company.model;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;


    /*@Override
    public int compareTo(Object o) {
        Employee employee=(Employee)o;
        if(this.getSalary() >employee.getSalary())
            return 1;
        if (this.getSalary() < employee.getSalary())
            return -1;
        else
            return 0;
    }*/
}
