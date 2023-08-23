package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Courses;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository;
import com.example.demo.model.Schedule2;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	/*
	 新增員工/管理者
	 method:post
	 url:http://localhost:8080/employee/add
	 語法：
		{
		    "employeeUserName": "test3",
		    "employeePassword": "1234",
		    "employeeName": "t3",
		    "employeeEmail": "t3@test.com",
		    "employeeRole": "admin",
		    "registrationTime": null,
		    "lastLoginTime": null,
		    "employeeStatus": "1"
		}
	*/
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(null);
		return employeeRepository.save(employee);
	}
	
	/*
	 查詢所有管理員
	 method:get
	 url:http://localhost:8080/employee/getAll
	*/
	@RequestMapping(value = "/employee/getAll", method = RequestMethod.GET)
	public List<Employee> getAllEmployee(Employee employee) {
		List<Employee> data = employeeRepository.findAll();
		return data;
	}
	
	// 刪除
	@RequestMapping(value = "/employee/delete/{employeeId}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		Employee existEmployee = employeeRepository.findByEmployeeId(employeeId);
		
		if(existEmployee != null) {
			employeeRepository.delete(existEmployee);
			return "成功刪除id:"+employeeId+"的員工";
		}else {
			return "找不到id:"+employeeId+"的員工";
		}
		
	}
	
	
	// 修改
	@RequestMapping(value = "/employee/update/{employeeId}", method = RequestMethod.PUT)
	public String updateEmployee(@PathVariable("employeeId") Integer employeeId, @RequestBody Employee employee) {
	
		Employee existEmployee = employeeRepository.findByEmployeeId(employeeId);

		if(existEmployee != null) {
			existEmployee.setEmployeePassword(employee.getEmployeePassword());
			existEmployee.setEmployeeName(employee.getEmployeeName());
			existEmployee.setEmployeeEmail(employee.getEmployeeEmail());
			existEmployee.setEmployeeStatus(employee.getEmployeeStatus());
			employeeRepository.save(existEmployee);
			
			return "成功更新id:"+employeeId+"的員工";
		}else {
			return "找不到id:"+employeeId+"的員工";
		}

	}

}
