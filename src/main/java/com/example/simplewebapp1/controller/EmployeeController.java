package com.example.simplewebapp1.controller;

import com.example.simplewebapp1.dto.EmployeeRequest;
import com.example.simplewebapp1.dto.EmployeeRequestForUpdate;
import com.example.simplewebapp1.dto.EmployeeResponse;
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
    public ResponseEntity<?> save(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.save(employeeRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        EmployeeResponse employeeResponse = employeeService.findById(id);
        return new ResponseEntity(employeeResponse, HttpStatus.FOUND);
    }

    @GetMapping("/lastName")
    public ResponseEntity<?> findByLastName(@RequestParam String lastName) {
        List<EmployeeResponse> employeeResponseList = employeeService.findByLastName(lastName);
        return new ResponseEntity(employeeResponseList, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<EmployeeResponse> employeeResponseList = employeeService.findAll();
        return new ResponseEntity(employeeResponseList, HttpStatus.FOUND);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody EmployeeRequestForUpdate employeeRequestForUpdate) {
        if (employeeService.update(employeeRequestForUpdate)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}