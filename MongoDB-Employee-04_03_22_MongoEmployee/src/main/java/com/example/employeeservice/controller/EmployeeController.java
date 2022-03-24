package com.example.employeeservice.controller;

import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repo.EmployeeRepository;
import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.ui.EmployeeRequestModel;
import com.example.employeeservice.ui.EmployeeResponseModel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
public class EmployeeController {
private final EmployeeService employeeService;
private final ModelMapper modelMapper;

@Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;

    }
    @PostMapping("/")
    public ResponseEntity<EmployeeResponseModel> createEmployee(@RequestBody EmployeeRequestModel employeeRequestModel) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        EmployeeDto employeeDto = modelMapper.map(employeeRequestModel, EmployeeDto.class);
        employeeDto.setEmployeeUniqueId(UUID.randomUUID().toString());
        employeeDto = employeeService.createEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(employeeDto,EmployeeResponseModel.class));
    }
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponseModel>> getEmployees()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<EmployeeResponseModel> list=new ArrayList<>();
        List<EmployeeDto> dtos=employeeService.getEmployees();
        for (EmployeeDto e:dtos)
        {
            list.add(modelMapper.map(e,EmployeeResponseModel.class));
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("/employeeId/{employeeUniqueId}")
    public ResponseEntity<EmployeeResponseModel> findEmployeeByEmployeeId(@PathVariable("employeeUniqueId") String employeeUniqueId)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return ResponseEntity.ok(modelMapper.map(employeeService.findEmployeeByEmployeeUniqueId(employeeUniqueId),EmployeeResponseModel.class));

    }
    @DeleteMapping("/email/{email}")
    public String deleteEmployeeByEmail(@PathVariable("email") String email)
    {
       employeeService.deleteEmployeeByEmail(email);
        return "deletion successful";
    }
    @DeleteMapping("/employeeId/{employeeUniqueId}")
    public String deleteEmployeeByEmployeeId(@PathVariable("employeeUniqueId") String employeeUniqueId)
    {
       employeeService.deleteEmployeeByEmployeeUniqueId(employeeUniqueId);
        return "deletion successful";
    }

}
