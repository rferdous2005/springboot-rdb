package com.vibradiant.Basic.Mysql.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    
    private Long id;
    @NotEmpty
    @Size(min=3, max=20, message = "first name must be 3-20 chars")
    
    private String firstName;
    @NotEmpty
    @Size(min=3, max=20, message = "last name must be 3-20 chars")
    
    private String lastName;

    @NotEmpty
    private String mobile;

    @NotEmpty
    @Email( message="Must be email address")
    
    private String email;

    @Max(value=2000000)
    private int salaryMonth;

    private Instant joinedOn;

}
