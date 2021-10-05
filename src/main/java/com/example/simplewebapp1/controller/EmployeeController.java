package com.example.simplewebapp1.controller;

import com.example.simplewebapp1.model.Employee;
import com.example.simplewebapp1.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Employee employee) {
        employeeService.save(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Employee employee = employeeService.findById(id);
        return new ResponseEntity(employee, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Employee> employeeList = employeeService.findAll();
        return new ResponseEntity(employeeList, HttpStatus.FOUND);
    }

    @PutMapping("/firstName/{id}")
    public ResponseEntity<?> updateFirstName(@PathVariable long id, @RequestParam String firstName) {
        if (employeeService.updateFirstName(id, firstName)) {
            return new ResponseEntity(HttpStatus.OK);
        }  else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/lastName/{id}")
    public ResponseEntity<?> updateLastName(@PathVariable long id, @RequestParam String lastName) {
        if (employeeService.updateLatsName(id, lastName)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}