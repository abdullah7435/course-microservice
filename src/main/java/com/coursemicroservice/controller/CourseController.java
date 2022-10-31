package com.coursemicroservice.controller;

import com.coursemicroservice.dao.CourseRepository;
import com.coursemicroservice.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;


    @PostMapping("addlistOfCoursesAgainstOneStudent/{studentId}")
    public ResponseEntity<List<Course>> addListOfContacts(@RequestBody List<Course> courses, @PathVariable("studentId") Long studentId) {

        for (int i = 0; i < courses.size(); i++) {
            courses.get(i).setCourseName(courses.get(i).getCourseName());
            courses.get(i).setStudentId(studentId);
            courseRepository.saveAll(courses);
        }
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }

    @GetMapping("getListOfCoursesAgainstOneStudent/{id}")
    public ResponseEntity<List<Course>> getListOfCourses(@PathVariable("id") Long id) {
        try {
            List<Course> courseList = new ArrayList<>();
            courseList = courseRepository.getAllCoursesByStudentId(id);
            return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Exception in trying to getting contacts");
            return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);
        }
    }
}
