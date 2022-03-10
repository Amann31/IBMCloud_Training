package com.example.user.controller;


import com.example.user.dto.UserDto;
import com.example.user.service.UserService;
import com.example.user.ui.UserRequestModel;
import com.example.user.ui.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @PostMapping("/users")
    public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto=modelMapper.map(userRequestModel,UserDto.class);
        userDto.setUserId(UUID.randomUUID().toString());
        userDto=userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(userDto,UserResponseModel.class));
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseModel>> getUsers()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UserResponseModel> list=new ArrayList<>();
        List<UserDto> dtos=userService.getUsers();
        for (UserDto d:dtos)
        {
            list.add(modelMapper.map(d,UserResponseModel.class));
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseModel> findUserByUserId(@PathVariable("userId") String userId)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return ResponseEntity.ok(modelMapper.map(userService.findUserByUserId(userId),UserResponseModel.class));

    }
    @GetMapping("/users/firstName/{firstName}")
    public ResponseEntity<UserResponseModel> findUserByFirstName(@PathVariable("firstName") String firstName)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return ResponseEntity.ok(modelMapper.map(userService.findUserByFirstName(firstName),UserResponseModel.class));

    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUserByUserId(@PathVariable("userId") String userId)
    {
        userService.deleteUserByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/users/userId/{userId}")
    public ResponseEntity<UserResponseModel> updateUserByUserId(@RequestBody UserRequestModel userRequestModel,@PathVariable("userId") String userId )
    {  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return ResponseEntity.ok(modelMapper.map(userService.updateUserByUserId(userRequestModel,userId),UserResponseModel.class));
    }

    @PutMapping("/users/email/{email}")
    public ResponseEntity<UserResponseModel> updateUserByEmail(@RequestBody UserRequestModel userRequestModel,@PathVariable("email") String email)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUserByEmail(userRequestModel,email));
    }

    @DeleteMapping("/users/email/{email}")
    public String deleteUserByEmail(@PathVariable("email") String email)
    {
        userService.deleteUserByEmail(email);
        return "deletion successful";
    }

}
