package com.example.simplewebapp1.service;

import com.example.simplewebapp1.dao.EmployeeDao;
import com.example.simplewebapp1.dto.EmployeeRequest;
import com.example.simplewebapp1.dto.EmployeeRequestForUpdate;
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
    public boolean update(EmployeeRequestForUpdate employeeRequestForUpdate) {
        Employee employee = employeeMapper.mapEmployeeRequestForUpdateToEmployee(employeeRequestForUpdate);
        if (employeeDao.containsById(employee.getId())) {
            employeeDao.update(employee);
        } else {
            return false;
        }
        return true;
    }
}