package com.example.simplewebapp1.mapper;


import com.example.simplewebapp1.dto.EmployeeRequest;
import com.example.simplewebapp1.dto.EmployeeResponse;
import com.example.simplewebapp1.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {

    public Employee mapEmployeeRequestToEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .departmentId(employeeRequest.getDepartmentId())
                .jobTitle(employeeRequest.getJobTitle())
                .gender(employeeRequest.getGender())
                .dateOfBirth(employeeRequest.getDateOfBirth())
                .build();
    }

    public EmployeeResponse mapEmployeeToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .departmentId(employee.getDepartmentId())
                .jobTitle(employee.getJobTitle())
                .gender(employee.getGender())
                .dateOfBirth(employee.getDateOfBirth())
                .build();
    }

    public List<EmployeeResponse> mapToEmployeeListToEmployeeResponseList(List<Employee> employeeList) {
        List<EmployeeResponse> employeeResponsesList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeResponse employeeResponse = mapEmployeeToEmployeeResponse(employee);
            employeeResponsesList.add(employeeResponse);
        }
        return employeeResponsesList;
    }
}
