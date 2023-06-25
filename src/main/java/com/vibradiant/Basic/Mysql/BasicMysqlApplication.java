package com.vibradiant.Basic.Mysql;

import com.vibradiant.Basic.Mysql.dto.Employee;
import com.vibradiant.Basic.Mysql.entity.EmployeeEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicMysqlApplication.class, args);
	}

}
