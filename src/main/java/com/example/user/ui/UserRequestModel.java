package com.example.user.ui;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String encryptedPassword;
}
