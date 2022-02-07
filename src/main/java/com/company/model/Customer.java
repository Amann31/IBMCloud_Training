package com.company.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Customer {
    private String customerName;
    private String customerAddress;
    private CustomerType customerType;

}
