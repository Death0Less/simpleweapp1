package com.example.simplewebapp1.service;

import com.example.simplewebapp1.dao.EmployeeDao;
import com.example.simplewebapp1.dto.EmployeeRequest;
import com.example.simplewebapp1.dto.EmployeeResponse;
import com.example.simplewebapp1.mapper.EmployeeMapper;
import com.example.simplewebapp1.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final EmployeeMapper employeeMapper;

    @Override
    public void save(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.mapEmployeeRequestToEmployee(employeeRequest);
        employeeDao.save(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeDao.deleteById(id);
    }

    @Override
    public EmployeeResponse findById(long id) {
        Employee employee = employeeDao.findById(id);
        return employeeMapper.mapEmployeeToEmployeeResponse(employee);
    }

    @Override
    public List<EmployeeResponse> findByLastName(String lastName) {
        List<Employee> employeeList = employeeDao.findByLastName(lastName);
        return employeeMapper.mapToEmployeeListToEmployeeResponseList(employeeList);
    }

    @Override
    public List<EmployeeResponse> findAll() {
        List<Employee> employeeList = employeeDao.findAll();
        return employeeMapper.mapToEmployeeListToEmployeeResponseList(employeeList);
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