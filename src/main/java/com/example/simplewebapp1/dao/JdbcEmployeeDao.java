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
        jdbcTemplate.update("insert into employees values(default, ?, ?, ?, ?, ?, ?)", employee.getFirstName(), employee.getLastName(),
                employee.getDepartmentId(), employee.getJobTitle(), employee.getGender().name(), employee.getDateOfBirth());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("delete from employees where employee_id = ?", id);
    }

    @Override
    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select * from employees where employee_id = ?", new Object[]{id}, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return jdbcTemplate.query("select * from employees where last_name = ?", new Object[]{lastName}, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employees", new EmployeeRowMapper());
    }

    @Override
    public void update(Employee employee) {
        jdbcTemplate.update("update employees set first_name = ?, last_name = ?, department_id = ?, job_title = ?, " +
                "gender = ?, date_of_birth = ? where employee_id = ? ", employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                employee.getJobTitle(), employee.getGender().name(), employee.getDateOfBirth(), employee.getId());
    }

    @Override
    public boolean containsById(long id) {
        try {
            jdbcTemplate.queryForObject("select * from employees where employee_id = ?", new Object[]{id}, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean containsByLastName(String lastName) {
        try {
            jdbcTemplate.queryForObject("select * from employees where last_name = ?", new Object[]{lastName}, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }
}