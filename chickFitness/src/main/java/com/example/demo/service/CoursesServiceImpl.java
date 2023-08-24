package com.example.demo.service;

import com.example.demo.model.Courses;
import com.example.demo.model.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository coursesRepository;

    @Autowired
    public CoursesServiceImpl(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public Optional<Courses> getCourseById(Integer id) {
        return coursesRepository.findById(id);
    }

    @Override
    public void createCourse(Courses course) {
        coursesRepository.save(course);
    }

    @Override
    public void updateCourse(Integer id, Courses course) {
        Optional<Courses> existingCourse = coursesRepository.findById(id);
        if (existingCourse.isPresent()) {
            course.setCourseId(id);
            coursesRepository.save(course);
        }
    }

    @Override
    public void deleteCourse(Integer id) {
        if (coursesRepository.existsById(id)) {
            coursesRepository.deleteById(id);
        }
    }
}
