package com.vibradiant.Basic.Mysql.repository;

import com.vibradiant.Basic.Mysql.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Override
    List<EmployeeEntity> findAll();
}
