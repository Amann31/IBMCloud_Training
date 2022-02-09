package org.example.repo;

import org.example.model.Employee;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component("employeeRepository")

public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final DataSource dataSource;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    public EmployeeRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getMyConnection() throws SQLException{
        return dataSource.getConnection();
    }


    @Override
    public Employee createEmployee(Employee employee) throws SQLException {
        connection=getMyConnection();
        preparedStatement=connection.prepareStatement("insert into employee(id,firstname,lastname,email) values(?,?,?,?)");
        preparedStatement.setInt(1,employee.getEmployeeId());
        preparedStatement.setString(2,employee.getFirstName());
        preparedStatement.setString(3,employee.getLastName());
        preparedStatement.setString(4,employee.getEmail());
        preparedStatement.executeUpdate();
        return employee;
    }

    @Override
    public Employee updateEmployee(Integer employeeId) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Employee employee = findEmployeeById(employeeId);
        if(employee==null)
        {
            System.out.println("Employee with ID: " +employeeId+" not found.");
        }
        else
        {
            System.out.println("Found employee");
            System.out.println("Enter new first name: ");
            String firstName = scanner.next();
            System.out.println("Enter new last name: ");
            String lastName = scanner.next();
            System.out.println("Enter new email: ");
            String email = scanner.next();
            System.out.println("Employee found.");
            connection = getMyConnection();
            preparedStatement=connection.prepareStatement("update employee set firstname=?, lastname=?, email=? where id=?");
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setString(3,employee.getEmail());
            preparedStatement.setInt(4,employeeId);
            preparedStatement.executeUpdate();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setEmployeeId(employeeId);
        }
            return employee;
    }

    @Override
    public Employee findEmployeeById(Integer employeeId) throws SQLException {
        connection=getMyConnection();
        preparedStatement=connection.prepareStatement("select * from employee where id=?");
        preparedStatement.setInt(1,employeeId);
        List<Employee> list = new ArrayList<>();
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            list.add(new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        }
        if(list.isEmpty())
        {
            return null;
        }
        else
        {
            return list.get(0);
        }
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        return null;
    }
}
