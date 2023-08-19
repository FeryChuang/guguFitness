package com.example.demo.service;

import com.example.demo.model.Courses;

import java.util.List;
import java.util.Optional;

public interface CoursesService {
    List<Courses> getAllCourses();
    Optional<Courses> getCourseById(Integer id);
    void createCourse(Courses course);
    void updateCourse(Integer id, Courses course);
    void deleteCourse(Integer id);
}
