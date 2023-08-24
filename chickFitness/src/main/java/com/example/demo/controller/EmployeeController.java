package com.example.demo.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository;


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
	
	// 登入
	 @Autowired
	    public EmployeeController(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }

	    @PostMapping("/employee/login")
	    public ModelAndView login(@RequestParam String employeeUserName, @RequestParam String employeePassword, HttpSession session) {
	    	Employee employee = employeeRepository.findByEmployeeUserNameAndEmployeePassword(employeeUserName, employeePassword);

	        if (employee != null) {
	            
	            session.setAttribute("loggedInEmployee", employee);
	            System.out.println(session.getAttribute("loggedInEmployee"));
	            ModelAndView model = new ModelAndView("redirect:/employeeMember.html");
	            return model;
	        } else {
	            ModelAndView model = new ModelAndView("redirect:/employeeSignin.html");
	            model.addObject("info", "Login failed"); 
	            return model;
	        }
	    }
	    
	    // 取得session
	    @RequestMapping(value="/employee/session",method=RequestMethod.GET)
	    public Employee getSession(HttpSession session) {
	   	 return (Employee)session.getAttribute("loggedInEmployee");
	    }
	

}
