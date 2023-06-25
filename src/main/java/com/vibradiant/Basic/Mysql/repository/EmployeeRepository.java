package com.vibradiant.Basic.Mysql.repository;

import com.vibradiant.Basic.Mysql.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Override
    List<EmployeeEntity> findAll();

    @Override
    EmployeeEntity save(EmployeeEntity employee);

    Optional<EmployeeEntity> findByCellNoOrEmail(String cellNo, String email);
}
