package com.example.employeeservice.repo;

import com.example.employeeservice.model.Employee;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository <Employee,Integer> {
@Query
public Employee findByEmployeeUniqueId(String employeeUniqueId);
@Query
public Employee findByEmail(String email);
@DeleteQuery
public void deleteByEmployeeUniqueId(String  employeeUniqueId);
}
