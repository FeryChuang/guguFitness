package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "chick")
public class Chick implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="chick_id")
    private Integer chickId;
    @Column(name="member_id")
	private Integer memberId;
    @Column(name="current_level")
    private Integer currentLevel;
    @Column(name="current_exp")
    private Integer currentExp;
    private Integer lifecount;
    @Column(name="user_name")
    private String userName;
    @Column(name="chick_stage")
    private String chickStage;
	public Chick() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chick(Integer chickId, Integer memberId, Integer currentLevel, Integer currentExp, Integer lifecount,
			String userName, String chickStage) {
		super();
		this.chickId = chickId;
		this.memberId = memberId;
		this.currentLevel = currentLevel;
		this.currentExp = currentExp;
		this.lifecount = lifecount;
		this.userName = userName;
		this.chickStage = chickStage;
	}
	public Integer getChickId() {
		return chickId;
	}
	public void setChickId(Integer chickId) {
		this.chickId = chickId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(Integer currentLevel) {
		this.currentLevel = currentLevel;
	}
	public Integer getCurrentExp() {
		return currentExp;
	}
	public void setCurrentExp(Integer currentExp) {
		this.currentExp = currentExp;
	}
	public Integer getLifecount() {
		return lifecount;
	}
	public void setLifecount(Integer lifecount) {
		this.lifecount = lifecount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getChickStage() {
		return chickStage;
	}
	public void setChickStage(String chickStage) {
		this.chickStage = chickStage;
	}
}
