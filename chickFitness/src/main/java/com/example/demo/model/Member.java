package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_id")
	private Integer memberId;
	
	@Column(name="user_name")
	private String userName;
	
	private String password, name, email;
	
	@Column(name="registration_date")
	private Date registrationDate;
	
	@Column(name="last_login_date")
	private Date lastLoginDate;

	public Member() {
	}

	public Member(String userName, String password, String name, String email) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;		
	}
	
	

	public Member(Integer memberId, String userName, String password, String name, String email, Date registrationDate,
			Date lastLoginDate) {
		super();
		this.memberId = memberId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.registrationDate = registrationDate;
		this.lastLoginDate = lastLoginDate;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", registrationDate=" + registrationDate + ", lastLoginDate=" + lastLoginDate
				+ "]";
	}

	

	

}
