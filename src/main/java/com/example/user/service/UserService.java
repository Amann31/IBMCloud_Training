package com.example.user.service;


import com.example.user.dto.UserDto;
import com.example.user.ui.UserRequestModel;
import com.example.user.ui.UserResponseModel;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public List<UserDto> getUsers();
    public UserDto findUserByUserId(String userId);
    public void deleteUserByUserId(String userId);
    UserDto updateUserByUserId(UserRequestModel userRequestModel, String userId);
    public void deleteUserByEmail(String email);
    public UserResponseModel updateUserByEmail(UserRequestModel userRequestModel, String email);
    public UserDto findUserByFirstName(String firstName);
}
