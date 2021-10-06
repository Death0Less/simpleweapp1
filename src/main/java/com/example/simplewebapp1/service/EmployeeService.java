package com.example.simplewebapp1.service;

import com.example.simplewebapp1.dto.EmployeeRequest;
import com.example.simplewebapp1.dto.EmployeeRequestForUpdate;
import com.example.simplewebapp1.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    void save(EmployeeRequest employeeRequest);
    void deleteById(long id);
    EmployeeResponse findById(long id);
    List<EmployeeResponse> findByLastName(String lastName);
    List<EmployeeResponse> findAll();
    boolean update(EmployeeRequestForUpdate employeeRequestForUpdate);
}