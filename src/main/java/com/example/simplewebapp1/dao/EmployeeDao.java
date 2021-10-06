package com.example.simplewebapp1.dao;

import com.example.simplewebapp1.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);
    void deleteById(long id);
    Employee findById(long id);
    List<Employee> findByLastName(String lastName);
    List<Employee> findAll();
    void update(Employee employee);
    boolean containsById(long id);
    boolean containsByLastName(String lastName);
}