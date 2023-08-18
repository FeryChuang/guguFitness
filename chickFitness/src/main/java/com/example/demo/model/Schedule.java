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
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer schedule_id;
	
	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false, referencedColumnName="member_id")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false, referencedColumnName="course_id")
	private Courses course;
	
	private Date redate;
	private String status;
	private Integer sort;
	private String schedule_name;
	private Date start_time;
	private Date end_time;
}
