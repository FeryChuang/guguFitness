package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer>{
	//Employee findByUserNameAndPassword (String userName, String Password);
	
	// 以員工ID查詢
	Employee findByEmployeeId(Integer getEmployeeId);
}
