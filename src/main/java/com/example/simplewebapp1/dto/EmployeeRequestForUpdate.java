package com.example.simplewebapp1.dto;

import com.example.simplewebapp1.model.Gender;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EmployeeRequestForUpdate {

    private long id;

    private String firstName;

    private String lastName;

    private long departmentId;

    private String jobTitle;

    private Gender gender;

    private Date dateOfBirth;
}
