package com.example.simplewebapp1.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private long id;

    private String firstName;

    private String lastName;

    private long departmentId;

    private String jobTitle;

    private Gender gender;

    private Date dateOfBirth;
}
