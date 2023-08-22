package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer course_id;
	private String course_name, description, difficulty, type, url;
	private Integer calories;
	@Column(name = "course_range")
	private Integer courseRange;
	
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(Integer course_id, String course_name, String description, String difficulty, String type,
			String url, Integer calories, Integer courseRange) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.description = description;
		this.difficulty = difficulty;
		this.type = type;
		this.url = url;
		this.calories = calories;
		this.courseRange = courseRange;
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getCourseRange() {
		return courseRange;
	}

	public void setCourseRange(Integer courseRange) {
		this.courseRange = courseRange;
	}

	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", course_name=" + course_name + ", description=" + description
				+ ", difficulty=" + difficulty + ", type=" + type + ", url=" + url + ", calories=" + calories
				+ ", courseRange=" + courseRange + "]";
	}

	
	
	
	
}
