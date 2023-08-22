package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//////請搭配SQL資料庫資料檔案並確認FK
@Entity
@Table(name="schedule2")
public class Schedule2 {
//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private Integer sid;
	
	@Column(name = "member_id")
	private Integer mid;
	
	@Column(name = "course_id")
	private Integer cid;
	
	private Integer week;
	
//constuctors
	public Schedule2() {}
	
	public Schedule2(Integer sid, Integer mid, Integer cid, Integer week) {
		this.sid = sid;
		this.mid = mid;
		this.cid = cid;
		this.week = week;
	}

//method - set&get
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
//toString
	@Override
	public String toString() {
		return "Schedule2 [sid=" + sid + ", mid=" + mid + ", cid=" + cid + ", week=" + week + "]";
	}
}
