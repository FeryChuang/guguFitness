package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "employee")
//@EntityListeners(EmployeeEntityListener.class)
public class Employee {
	
	//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // sql ai
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="employee_user_name")
	private String employeeUserName;

	@Column(name="employee_password")
	private String employeePassword;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="employee_email")
	private String employeeEmail;
	
	// 預留角色欄位
	@Column(name="employee_role")
	private String employeeRole;
	
	// 註冊時間
	@Column(name="registration_time")
	private Date registrationTime;
	
	// 最後登入時間
	@Column(name="last_login_time")
	private Date lastLoginTime;
	
	// 帳號狀態
	@Column(name="employee_status")
	private String employeeStatus;

	public Employee() {
		
	}

	public Employee(Integer employeeId, String employeeUserName, String employeePassword, String employeeName,
			String employeeEmail, String employeeRole, Date registrationTime, Date lastLoginTime,
			String employeeStatus) {
		this.employeeId = employeeId;
		this.employeeUserName = employeeUserName;
		this.employeePassword = employeePassword;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeRole = employeeRole;
		this.registrationTime = registrationTime;
		this.lastLoginTime = lastLoginTime;
		this.employeeStatus = employeeStatus;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeUserName() {
		return employeeUserName;
	}

	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeUserName=" + employeeUserName + ", employeePassword="
				+ employeePassword + ", employeeName=" + employeeName + ", employeeEmail=" + employeeEmail
				+ ", employeeRole=" + employeeRole + ", registrationTime=" + registrationTime + ", lastLoginTime="
				+ lastLoginTime + ", employeeStatus=" + employeeStatus + "]";
	}

	
}
