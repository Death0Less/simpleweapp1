package com.example.simplewebapp1.service;

import com.example.simplewebapp1.dto.EmployeeRequest;
import com.example.simplewebapp1.dto.EmployeeResponse;
import com.example.simplewebapp1.model.Employee;

import java.util.List;

public interface EmployeeService {

    void save(EmployeeRequest employeeRequest);
    void deleteById(long id);
    EmployeeResponse findById(long id);
    List<EmployeeResponse> findByLastName(String lastName);
    List<EmployeeResponse> findAll();
    boolean updateFirstName(long id, String fistName);
    boolean updateLatsName(long id, String lastName);
}