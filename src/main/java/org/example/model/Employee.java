package org.example.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
}
