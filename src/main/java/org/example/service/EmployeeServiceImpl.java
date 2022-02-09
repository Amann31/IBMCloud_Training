package org.example.service;

import org.example.model.Employee;
import org.example.repo.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) throws SQLException {
        return employeeRepository.createEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Integer employeeId) throws SQLException {
        return employeeRepository.updateEmployee(employeeId);
    }

    @Override
    public Employee findEmployeeById(Integer employeeId) throws SQLException {
        return employeeRepository.findEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        return null;
    }
}
