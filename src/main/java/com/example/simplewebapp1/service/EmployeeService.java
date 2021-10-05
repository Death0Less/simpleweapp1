package com.example.simplewebapp1.service;

import com.example.simplewebapp1.model.Employee;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);
    void deleteById(long id);
    Employee findById(long id);
    List<Employee> findAll();
    boolean updateFirstName(long id, String fistName);
    boolean updateLatsName(long id, String lastName);
}