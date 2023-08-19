package com.example.demo.controller;

import com.example.demo.model.Courses;
import com.example.demo.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

@RestController
public class CoursesController {

    private final CoursesService coursesService;

    @Autowired
    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }
    
    @PostConstruct
    //新增課程
    public void initFixedCourses() {
        Courses course1 = new Courses(null, "課程名稱1", "課程介紹1", "中", "有氧舞蹈", "your-video1.mp4", 10, 200);
        Courses course2 = new Courses(null, "課程名稱2", "課程介紹2", "低", "跑步", "your-video2.mp4", 10, 100);
        // 類似地創建其他固定內容的 Courses 物件

        coursesService.createCourse(course1);
        coursesService.createCourse(course2);
        // 儲存到資料庫
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCourses() {
        List<Courses> allCourses = coursesService.getAllCourses();
        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCourseById(@PathVariable("id") Integer id) {
        Optional<Courses> optionalCourse = coursesService.getCourseById(id);
        if (optionalCourse.isPresent()) {
            return new ResponseEntity<>(optionalCourse.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course with specified ID not found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public ResponseEntity<Object> createCourse(@RequestBody Courses course) {
        coursesService.createCourse(course);
        return new ResponseEntity<>("Course is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCourse(@PathVariable("id") Integer id, @RequestBody Courses course) {
        coursesService.updateCourse(id, course);
        return new ResponseEntity<>("Course is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCourse(@PathVariable("id") Integer id) {
        coursesService.deleteCourse(id);
        return new ResponseEntity<>("Course is deleted successfully", HttpStatus.OK);
    }
}
