package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.model.Courses;
import com.example.demo.model.Member;
import com.example.demo.model.MemberRepository;
import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduleRepository;
import com.example.demo.service.CoursesService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo"})
public class ChickFitnessApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(ChickFitnessApplication.class, args);
	}

//Schedule部分

	@Autowired
	ScheduleRepository sReps;
	@Autowired
    CoursesService coursesService;
	@Autowired
	MemberRepository dao;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Courses course1 = new Courses(null, "課程名稱1", "課程介紹1", "中", "有氧舞蹈", "your-video1.mp4", 10, 200);
//        Courses course2 = new Courses(null, "課程名稱2", "課程介紹2", "低", "跑步", "your-video2.mp4", 10, 100);
//        coursesService.createCourse(course1);
//        coursesService.createCourse(course2);
	}

}
