package com.example.user;

import com.example.user.entity.UserEntity;
import com.example.user.repository.UserRepository;
import com.example.user.ui.ErrorResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired
    public UserApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

    @Bean
    public ErrorResponseModel errorResponseModel()
    {
        return new ErrorResponseModel();
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new UserEntity(UUID.randomUUID().toString(),"John","Doe","john@email.com","tytyt"));
        userRepository.save(new UserEntity(UUID.randomUUID().toString(),"Marry","Public","marry@email.com","uyuyuuy"));
        userRepository.save(new UserEntity(UUID.randomUUID().toString(),"Daniel","Smith","daniel@email.com","uiyuyu"));
        userRepository.save(new UserEntity(UUID.randomUUID().toString(),"Sachin","Tendulkar","sachin@email.com","uiuj"));

    }
}
