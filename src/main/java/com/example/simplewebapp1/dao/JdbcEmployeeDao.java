package com.example.simplewebapp1.dao;

import com.example.simplewebapp1.mapper.EmployeeRowMapper;
import com.example.simplewebapp1.model.Employee;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcEmployeeDao implements EmployeeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcEmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Employee employee) {
        jdbcTemplate.update("insert into employee values(default, ?, ?, ?, ?, ?, ?)", employee.getFirstName(), employee.getLastName(),
                employee.getDepartmentId(), employee.getJobTitle(), employee.getGender().name(), employee.getDateOfBirth());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("delete from employee where employee_id = ?", id);
    }

    @Override
    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select * from employee where employee_id = ?", new Object[]{id}, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
    }

    @Override
    public void updateFirstName(long id, String firstName) {
        jdbcTemplate.update("update employee set first_name = ? where employee_id = ?", firstName, id);
    }

    @Override
    public void updateLatsName(long id, String lastName) {
        jdbcTemplate.update("update employee set last_name = ? where employee_id = ?", lastName, id);
    }

    @Override
    public boolean containsById(long id) {
        try {
            jdbcTemplate.queryForObject("select * from employee where employee_id = ?", new Object[]{id}, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean containsByLastName(String lastName) {
        try {
            jdbcTemplate.queryForObject("select * from employee where last_name = ?", new Object[]{lastName}, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }
}