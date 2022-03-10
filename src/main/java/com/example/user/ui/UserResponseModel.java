package com.example.user.ui;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseModel {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String encryptedPassword;
}
