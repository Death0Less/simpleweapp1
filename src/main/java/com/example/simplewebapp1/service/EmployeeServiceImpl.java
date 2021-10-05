package com.example.simplewebapp1.service;

import com.example.simplewebapp1.dao.EmployeeDao;
import com.example.simplewebapp1.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Employee findById(long id) {
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public boolean updateFirstName(long id, String fistName) {
        if (employeeDao.containsById(id)) {
            employeeDao.updateFirstName(id, fistName);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateLatsName(long id, String lastName) {
        if (employeeDao.containsById(id)) {
            employeeDao.updateLatsName(id, lastName);
        } else {
            return false;
        }
        return true;
    }
}