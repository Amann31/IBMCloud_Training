package com.example.employeeservice;

import com.example.employeeservice.exception.ErrorResponseModel;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repo.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class EmployeeServiceApplication implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
    @Bean
    public ErrorResponseModel errorResponseModel()
    {
        return  new ErrorResponseModel();
    }


    @Override
    public void run(String... args) throws Exception {
        employeeRepository.save(new Employee(1, UUID.randomUUID().toString(),"John","Technical",25000.0,"john@email.com"));
        employeeRepository.save(new Employee(2, UUID.randomUUID().toString(),"Marry","Technical",25000.0,"marry@email.com"));
    }
}
