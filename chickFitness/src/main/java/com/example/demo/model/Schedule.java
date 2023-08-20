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

	private Date redate;
	private String status;
	private Integer sort;
	
	@Column(name = "schedule_name")
	private String sname;
	
	@Column(name = "start_time")
	private Date startime;
	
	@Column(name = "end_time")
	private Date endtime;
	
//constructors

}
