package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//////請搭配SQL資料庫資料檔案並確認FK
@Entity
@Table(name="schedule3")
public class Schedule3 {
//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private Integer sid;
	
	@Column(name = "member_id")
	private Integer mid;
	
	@Column(name = "course_id")
	private Integer cid;
	
	private 
	Boolean mon, tue, wed, thu, fri, sat, sun;
	
	public Schedule3() {}

	public Schedule3(Integer sid, Integer mid, Integer cid, Boolean mon, Boolean tue, Boolean wed, Boolean thu,
			Boolean fri, Boolean sat, Boolean sun) {
		super();
		this.sid = sid;
		this.mid = mid;
		this.cid = cid;
		this.mon = mon;
		this.tue = tue;
		this.wed = wed;
		this.thu = thu;
		this.fri = fri;
		this.sat = sat;
		this.sun = sun;
	}

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

	public Boolean getMon() {
		return mon;
	}

	public void setMon(Boolean mon) {
		this.mon = mon;
	}

	public Boolean getTue() {
		return tue;
	}

	public void setTue(Boolean tue) {
		this.tue = tue;
	}

	public Boolean getWed() {
		return wed;
	}

	public void setWed(Boolean wed) {
		this.wed = wed;
	}

	public Boolean getThu() {
		return thu;
	}

	public void setThu(Boolean thu) {
		this.thu = thu;
	}

	public Boolean getFri() {
		return fri;
	}

	public void setFri(Boolean fri) {
		this.fri = fri;
	}

	public Boolean getSat() {
		return sat;
	}

	public void setSat(Boolean sat) {
		this.sat = sat;
	}

	public Boolean getSun() {
		return sun;
	}

	public void setSun(Boolean sun) {
		this.sun = sun;
	}

	@Override
	public String toString() {
		return "Schedule3 [sid=" + sid + ", mid=" + mid + ", cid=" + cid + ", mon=" + mon + ", tue=" + tue + ", wed="
				+ wed + ", thu=" + thu + ", fri=" + fri + ", sat=" + sat + ", sun=" + sun + "]";
	}

	
	
}
