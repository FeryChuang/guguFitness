package com.example.demo.model;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component
public class EmployeeEntityListener {
	
	@PrePersist
	public void prePersist(Employee employee) {
		//在新增進資料庫之前先設定這兩個日期
		employee.setRegistrationTime(new Date());
		employee.setLastLoginTime(new Date());
	}
	
	@PreUpdate
	public void preUpdate(Employee employee) {
		//在每次更新時都再設定一次當前日期
		employee.setLastLoginTime(new Date());
	}

}
