package com.example.user.service;


import com.example.user.dto.UserDto;
import com.example.user.entity.UserEntity;
import com.example.user.exception.UserNotFoundException;
import com.example.user.repository.UserRepository;
import com.example.user.ui.UserRequestModel;
import com.example.user.ui.UserResponseModel;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity=modelMapper.map(userDto,UserEntity.class);
        StringBuilder stringBuilder=new StringBuilder(userDto.getEncryptedPassword());
        userEntity.setEncryptedPassword(stringBuilder.reverse().toString());
        userEntity=userRepository.save(userEntity);
        return modelMapper.map(userEntity,UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UserDto> list=new ArrayList<>();
        Iterable<UserEntity> iterable= userRepository.findAll();

        Iterator<UserEntity> iterator= iterable.iterator();
        while (iterator.hasNext())
        {
            list.add(modelMapper.map(iterator.next(),UserDto.class));
        }
        return list;
    }

    @Override
    public UserDto findUserByUserId(String userId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity= findUserId(userId);
        if(userEntity==null)
        {
            throw new UserNotFoundException("user with id: "+userId+" not found");
        }
        return modelMapper.map(userEntity,UserDto.class);
    }


    private UserEntity findUserId(String userId) {

        UserEntity userEntity= userRepository.findByUserId(userId);
        return userEntity;
    }
    private UserEntity findFirstName(String firstName) {

        UserEntity userEntity= userRepository.findByFirstName(firstName);
        return userEntity;
    }


    private UserEntity findUserByEmail(String email)
    {
        UserEntity userEntity=userRepository.findByEmail(email);
        return userEntity;
    }

    @Override
    public void deleteUserByUserId(String userId) {

        UserEntity userEntity=findUserId(userId);
        if(userEntity==null)
        {
            throw new UserNotFoundException("user with id: "+userId+" not found");
        }

        userRepository.delete(userEntity);

    }

    @Override
    public UserDto updateUserByUserId(UserRequestModel userRequestModel, String userId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity= findUserId(userId);
        if(userEntity==null)
        {
            throw new UserNotFoundException("user with id: "+userId+" not found");
        }
        userEntity.setFirstName(userRequestModel.getFirstName());
        userEntity.setLastName(userRequestModel.getLastName());
        userEntity.setEmail(userRequestModel.getEmail());

        StringBuilder stringBuilder=new StringBuilder(userRequestModel.getEncryptedPassword());
        userEntity.setEncryptedPassword(stringBuilder.reverse().toString());
        userEntity=userRepository.save(userEntity);
        return modelMapper.map(userEntity,UserDto.class);

    }


    @Override
    public UserResponseModel updateUserByEmail(UserRequestModel userRequestModel, String email) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity entity=findUserByEmail(email);
        if (entity==null)
        {
            throw new UserNotFoundException("user with "+email+" not found");
        }
        entity.setFirstName(userRequestModel.getFirstName());
        entity.setLastName(userRequestModel.getLastName());
        entity.setEmail(userRequestModel.getEmail());
        userRepository.save(entity);
        return modelMapper.map(entity,UserResponseModel.class);
    }

    @Override
    public UserDto findUserByFirstName(String firstName) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity= findFirstName(firstName);
        if(userEntity==null)
        {
            throw new UserNotFoundException("user with name: "+firstName+" not found");
        }
        return modelMapper.map(userEntity,UserDto.class);
    }

    @Override
    public void deleteUserByEmail(String email) {
        UserEntity entity=findUserByEmail(email);
        if (entity==null)
        {
            throw new UserNotFoundException("user with email "+email+" not found");
        }

        userRepository.delete(entity);
    }

}

