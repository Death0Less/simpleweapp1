package com.example.simplewebapp1;

import com.example.simplewebapp1.config.AppConfiguration;
import com.example.simplewebapp1.dao.EmployeeDao;
import com.example.simplewebapp1.dao.JdbcEmployeeDao;
import com.example.simplewebapp1.model.Employee;
import com.example.simplewebapp1.model.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

class EmployeeDaoTests {

    static EmployeeDao employeeDao;
    static AppConfiguration appConfiguration;

    @BeforeAll
    static void init() {
        appConfiguration = new AppConfiguration();
        employeeDao = new JdbcEmployeeDao(appConfiguration.jdbcTemplate());
    }

    @Test
    void save() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("test1");
        employee.setLastName("test1");
        employee.setDepartmentId(1L);
        employee.setJobTitle("test1");
        employee.setGender(Gender.MALE);
        employee.setDateOfBirth(new Date());
        employeeDao.save(employee);
        Assertions.assertTrue(employeeDao.containsByLastName(employee.getLastName()));
    }

    @Test
    void deleteById() {
        employeeDao.deleteById(6L);
        Assertions.assertFalse(employeeDao.containsById(6l));
    }

    @Test
    void findById() {
        Employee employee = employeeDao.findById(11L);
        Assertions.assertTrue(employeeDao.containsByLastName(employee.getLastName()));
    }

    @Test
    void findAll() {
        List<Employee> employeeList = employeeDao.findAll();
        Assertions.assertTrue(employeeList.size() > 0);
    }

   @Test
    void update() {
        Employee employee = new Employee();
        employee.setId(5L);
        employee.setFirstName("ttttt");
        employee.setLastName("ttttt");
        employee.setDepartmentId(5L);
        employee.setJobTitle("ttttt");
        employee.setGender(Gender.FEMALE);
        employee.setDateOfBirth(new Date());
        employeeDao.update(employee);
        Assertions.assertEquals(employee.getLastName(), "ttttt");
    }
}
