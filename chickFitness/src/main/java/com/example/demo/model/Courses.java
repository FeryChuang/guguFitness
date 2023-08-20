package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="courses")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer course_id;
	private String course_name, description, difficulty, type, URL;
	private Integer calories;
	@Column(name = "course_range")
	private Integer range;

	public Courses(Integer course_id, String course_name, String description, String difficulty, String type,
            String uRL, Integer range, Integer calories) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.description = description;
		this.difficulty = difficulty;
		this.type = type;
		URL = uRL;
		this.range = range;
		this.calories = calories;
}
	

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCourese_id() {
		return course_id;
	}
	public void setCourese_id(Integer course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public Integer getRange() {
		return range;
	}
	public void setRange(Integer range) {
		this.range = range;
	}
	public Integer getCalories() {
		return calories;
	}
	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	@Override
	public String toString() {
		return "Courses [courese_id=" + course_id + ", course_name=" + course_name + ", description=" + description
				+ ", difficulty=" + difficulty + ", type=" + type + ", URL=" + URL + ", range=" + range + ", calories="
				+ calories + "]";
	}
	
	
	
	
}
