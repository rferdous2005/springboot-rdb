package com.vibradiant.Basic.Mysql.controller;

import com.vibradiant.Basic.Mysql.dto.Employee;
import com.vibradiant.Basic.Mysql.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    @GetMapping("")
    public ResponseEntity<List<Employee>> getEmployeeList() {
        List<Employee> employeeList = employeeService.readAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.FOUND);
    }

    @PostMapping("")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return  new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }
}
