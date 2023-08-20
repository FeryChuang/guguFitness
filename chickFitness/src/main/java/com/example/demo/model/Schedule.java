package com.example.demo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
//field
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer schedule_id;
//待處理ManyToOne與OnToMany的對應
	private Integer member_id;
	private Integer course_id;
	
//	@ManyToOne
//	@JoinColumn(name = "member_id", nullable = false, referencedColumnName="member_id")
//	private Member member;
//
//	@ManyToOne
//	@JoinColumn(name = "course_id", nullable = false, referencedColumnName="course_id")
//	private Courses course;

	private Date redate;
	private String status;
	private Integer sort;
	private String schedule_name;
	private Date start_time;
	private Date end_time;
	
//constructors
	public Schedule(Integer member_id, Integer course_id, Date redate, String status, Integer sort,
			String schedule_name) {
		super();
		this.member_id = member_id;
		this.course_id = course_id;
		this.redate = redate;
		this.status = status;
		this.sort = sort;
		this.schedule_name = schedule_name;
	}
	public Schedule(Integer course_id, Date redate, String status, Integer sort, String schedule_name) {
		super();
		this.course_id = course_id;
		this.redate = redate;
		this.status = status;
		this.sort = sort;
		this.schedule_name = schedule_name;
	}
	
//	public Schedule(Courses course, Date redate, String status, Integer sort, String schedule_name) {
//		super();
//		this.course = course;
//		this.redate = redate;
//		this.status = status;
//		this.sort = sort;
//		this.schedule_name = schedule_name;
//	}
//
//	public Schedule(Member member, Courses course, Date redate, String status, Integer sort, String schedule_name) {
//		super();
//		this.member = member;
//		this.course = course;
//		this.redate = redate;
//		this.status = status;
//		this.sort = sort;
//		this.schedule_name = schedule_name;
//	}
	
}
