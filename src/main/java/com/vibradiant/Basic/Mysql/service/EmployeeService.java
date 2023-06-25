package com.vibradiant.Basic.Mysql.service;

import com.vibradiant.Basic.Mysql.dto.Employee;
import com.vibradiant.Basic.Mysql.entity.EmployeeEntity;
import com.vibradiant.Basic.Mysql.mapper.EmployeeMapper;
import com.vibradiant.Basic.Mysql.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository; // auto Bean cause extends JpaRepo
    public List<Employee> readAllEmployee() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employeeList = employeeEntities.stream()
                .map((employeeEntity) -> EmployeeMapper.INSTANCE.mapToDto(employeeEntity))
                .collect(Collectors.toList());
        return employeeList;
    }

    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = EmployeeMapper.INSTANCE.maptoEntity(employee);
        EmployeeEntity returnedEntity = employeeRepository.save(employeeEntity);
        employee = EmployeeMapper.INSTANCE.mapToDto(returnedEntity);
        return employee;
    }
}
