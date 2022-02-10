package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "email")
    private String email;

    public Customer(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
    }

}
