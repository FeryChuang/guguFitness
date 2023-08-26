package com.example.demo.controller;

import com.example.demo.model.Courses;
import com.example.demo.model.CoursesRepository;
import com.example.demo.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

@RestController
public class CoursesController {
	@Autowired
    private final CoursesService coursesService;
	@Autowired
    private final CoursesRepository coursesRepository;

    
    public CoursesController(CoursesRepository coursesRepository, CoursesService coursesService) {
        this.coursesService = coursesService;
        this.coursesRepository = coursesRepository;
    }
    
    @PostConstruct
   
    public void initFixedCourses() {

    }

    @RequestMapping(value = "/courses/all", method = RequestMethod.GET)
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
    
    @RequestMapping(value = "/courses/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCourse(@PathVariable("id") Integer id, @RequestBody Courses course) {
        Optional<Courses> existingCourse = coursesService.getCourseById(id);
        
        if (existingCourse.isPresent()) {
            Courses updatedCourse = existingCourse.get();
            // 更新課程資訊
            updatedCourse.setCourseName(course.getCourseName());
            updatedCourse.setDescription(course.getDescription());
            updatedCourse.setDifficulty(course.getDifficulty());
            updatedCourse.setCalories(course.getCalories());
            updatedCourse.setType(course.getType());
            updatedCourse.setUrl(course.getUrl());
            updatedCourse.setCourseRange(course.getCourseRange());
           
            
            coursesService.updateCourse(id, updatedCourse);
            return new ResponseEntity<>("Course is updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course with specified ID not found", HttpStatus.NOT_FOUND);
        }
    }

    

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCourse(@PathVariable("id") Integer id) {
        coursesService.deleteCourse(id);
        return new ResponseEntity<>("Course is deleted successfully", HttpStatus.OK);
    }
    


}
