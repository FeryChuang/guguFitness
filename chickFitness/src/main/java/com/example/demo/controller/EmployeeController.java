package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	// 新增員工/管理者
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(null);
		employee.setRegistrationTime(new Date());
		return employeeRepository.save(employee);
	}
	
	// 查詢
	// 查詢所有管理員
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Employee> getAllEmployee(Employee employee) {
		List<Employee> data = employeeRepository.findAll();
		return data;
	}
	
	// 依id查詢管理員
	@RequestMapping(value = "/search/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);

        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee with specified ID not found", HttpStatus.NOT_FOUND);
        }
    }
	
	/*
	// 依id查詢管理員
	@RequestMapping(value = "/get/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getByEmployeeId(@PathVariable("employeeId") Integer employeeId) {
        Employee existEmployee = employeeRepository.findByEmployeeId(employeeId);

        if (existEmployee != null) {
            return ResponseEntity.ok(existEmployee); // 回傳查詢到的員工資料
        } else {
            String message = "找不到id:" + employeeId + "的員工";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message); // 回傳錯誤訊息
        }
    }
    */
	
	// 刪除
	@RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.DELETE)
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
	@RequestMapping(value = "/update/{employeeId}", method = RequestMethod.PUT)
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
		
	//登入
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String employeeUserName, @RequestParam String employeePassword, HttpSession session) {
    	Employee existEmployee = employeeRepository.findByEmployeeUserNameAndEmployeePassword(employeeUserName, employeePassword);
        if (existEmployee != null) {
            session.setAttribute("loggedInEmployee", existEmployee);
            // 更新最後登入時間
            existEmployee.setLastLoginTime(new Date());
            employeeRepository.save(existEmployee);
            System.out.println(session.getAttribute("loggedInEmployee"));
            ModelAndView model = new ModelAndView("redirect:/employeeHome.html");
            return model;
        } else {
        	session.setAttribute("loginFailedMessage", "登入失敗，請確認您輸入的帳號與密碼是否正確"); // 儲存錯誤訊息到Session
            ModelAndView model = new ModelAndView("redirect:/employeeSignin.html");
            return model;
        }
    }
    
    // 登入錯誤訊息
    @GetMapping("/loginerror")
    @ResponseBody
    public String getErrorMessage(HttpSession session) {
        String errorMessage = (String) session.getAttribute("loginFailedMessage");
        if (errorMessage != null) {
            session.removeAttribute("loginFailedMessage"); // 清除錯誤訊息
            return errorMessage;
        } else {
            return ""; // 如果沒有錯誤訊息，回傳空字串
        }
    }
    
    // 登出
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        // 清除登入session
        session.removeAttribute("loggedInEmployee");
        ModelAndView model = new ModelAndView("redirect:/employeeSignin.html");
        return model;
    }
    
    
    // 取得session
    @RequestMapping(value="/session",method=RequestMethod.GET)
    public Employee getSession(HttpSession session) {
    	return (Employee)session.getAttribute("loggedInEmployee");
    }
}
