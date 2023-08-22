package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {
//field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private Integer sid;
//待處理ManyToOne與OnToMany的對應
	@Column(name = "member_id")
	private Integer mid;
	@Column(name = "course_id")
	private Integer cid;
	
//	@ManyToOne
//	@JoinColumn(name = "member_id", nullable = false, referencedColumnName="member_id")
//	private Member member;
//
//	@ManyToOne
//	@JoinColumn(name = "course_id", nullable = false, referencedColumnName="course_id")
//	private Courses course;

	private LocalDate redate;
	private String status;
	private Integer sort;
	
	@Column(name = "schedule_name")
	private String sname;
	
	@Column(name = "start_time")
	private Date startime;
	
	@Column(name = "end_time")
	private Date endtime;

//constructors
	public Schedule() {}

	public Schedule(Integer sid, Integer mid, Integer cid, LocalDate redate, String status, Integer sort, String sname,
			Date startime, Date endtime) {
		super();
		this.sid = sid;
		this.mid = mid;
		this.cid = cid;
		this.redate = redate;
		this.status = status;
		this.sort = sort;
		this.sname = sname;
		this.startime = startime;
		this.endtime = endtime;
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

	public LocalDate getRedate() {
		return redate;
	}

	public void setRedate(LocalDate redate) {
		this.redate = redate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getStartime() {
		return startime;
	}

	public void setStartime(Date startime) {
		this.startime = startime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Override
	public String toString() {
		return "Schedule [sid=" + sid + ", mid=" + mid + ", cid=" + cid + ", redate=" + redate + ", status=" + status
				+ ", sort=" + sort + ", sname=" + sname + ", startime=" + startime + ", endtime=" + endtime + "]";
	}
}
