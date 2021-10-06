package com.example.simplewebapp1.mapper;

import com.example.simplewebapp1.model.Employee;
import com.example.simplewebapp1.model.Gender;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong(1);
        String firstName = rs.getString(2);
        String lastName = rs.getString(3);
        long departmentId = rs.getLong(4);
        String jobTitle = rs.getString(5);
        String gender = rs.getString(6);
        Date dateOfBirth = rs.getDate(7);
        return new Employee(id, firstName, lastName, departmentId, jobTitle, Gender.valueOf(gender), dateOfBirth);
    }
}