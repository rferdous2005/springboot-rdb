package com.vibradiant.Basic.Mysql.service;

import com.vibradiant.Basic.Mysql.dto.Employee;
import com.vibradiant.Basic.Mysql.entity.EmployeeEntity;
import com.vibradiant.Basic.Mysql.exception.EntityAlreadyExistsException;
import com.vibradiant.Basic.Mysql.exception.EntityNotFoundException;
import com.vibradiant.Basic.Mysql.mapper.EmployeeMapper;
import com.vibradiant.Basic.Mysql.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository; // auto Bean cause extends JpaRepo

    public List<Employee> readEmployeeList() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employeeList = employeeEntities.stream()
                .map((employeeEntity) -> EmployeeMapper.INSTANCE.mapToDto(employeeEntity))
                .collect(Collectors.toList());
        return employeeList;
    }

    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = EmployeeMapper.INSTANCE.mapToEntity(employee);
        Optional<EmployeeEntity> existing = employeeRepository.findByCellNoOrEmail(employeeEntity.getCellNo(), employee.getEmail());
        if(existing.isPresent()) {
            throw new EntityAlreadyExistsException("Employee exists with same mobile or email");
        }
        else {
            EmployeeEntity returnedEntity = employeeRepository.save(employeeEntity);
            employee = EmployeeMapper.INSTANCE.mapToDto(returnedEntity);
            return employee;
        }

    }
    public Employee updateEmployee(Employee employee) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employee.getId());
        if(employeeEntity.isPresent()) {
            EmployeeEntity returned = employeeEntity.get();
            EmployeeEntity updated = EmployeeMapper.INSTANCE.mapToEntity(employee);
            returned.setFirstName(updated.getFirstName());
            returned.setLastName(updated.getLastName());
            returned.setSalaryMonth(updated.getSalaryMonth());
            returned.setCellNo(updated.getCellNo());
            returned.setEmail(updated.getEmail());
            EmployeeEntity saved = employeeRepository.save(returned);
            return EmployeeMapper.INSTANCE.mapToDto(saved);
        } else {
            throw new EntityNotFoundException("Employee", "id", employee.getId().toString());
        }
    }
}
