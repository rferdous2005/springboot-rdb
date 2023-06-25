package com.vibradiant.Basic.Mysql.mapper;

import com.vibradiant.Basic.Mysql.dto.Employee;
import com.vibradiant.Basic.Mysql.entity.EmployeeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "mobile", source = "cellNo")
    @Mapping(target = "joinedOn", source = "createdAt")
    Employee mapToDto(EmployeeEntity employeeEntity);

//    @Mapping(target = "cellNo", source = "mobile")
//    @Mapping(target = "createdAt", source = "joinedOn")
    @InheritInverseConfiguration
    EmployeeEntity maptoEntity(Employee employee);
}
