package com.example.demo.model;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component
public class MemberEntityListener {

	@PrePersist
	public void prePersist(Member member) {
		//在新增進資料庫之前先設定這兩個日期
		member.setRegistrationDate(new Date());
		member.setLastLoginDate(new Date());
	}
	
	@PreUpdate
	public void preUpdate(Member member) {
		//在每次更新時都再設定一次當前日期
		member.setLastLoginDate(new Date());
	}
}
