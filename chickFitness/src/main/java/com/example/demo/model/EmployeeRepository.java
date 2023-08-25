package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer>{
	// 查詢員工帳號和密碼
	Employee findByEmployeeUserNameAndEmployeePassword (String employeeUserName, String employeePassword);
	// 查詢員工帳號
	Employee findByEmployeeUserName (String employeeUserName);
	// 以員工ID查詢
	Employee findByEmployeeId(Integer EmployeeId);
}
