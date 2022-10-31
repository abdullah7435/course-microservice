package com.coursemicroservice.entity;

import javax.persistence.*;


@Entity
@Table(name = "coursetable", schema = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long cId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "student_id")
    private Long studentId;

    public Course() {
    }

    public Course(Long cId, String courseName, Long studentId) {
        this.cId = cId;
        this.courseName = courseName;
        this.studentId = studentId;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
