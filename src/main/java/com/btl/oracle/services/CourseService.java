package com.btl.oracle.services;

import com.btl.oracle.dtos.CourseDTO;
import com.btl.oracle.entities.Course;
import com.btl.oracle.entities.Department;
import com.btl.oracle.exception.ResourceNotFoundException;
import com.btl.oracle.repositories.CourseRepository;
import com.btl.oracle.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(CourseDTO req) {
        Department department = departmentRepository.findById(req.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        Course course = Course.builder()
                .courseName(req.getCourseName())
                .department(department)
                .build();
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, CourseDTO courseDetails) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        Department department = departmentRepository.findById(courseDetails.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        course.setCourseName(courseDetails.getCourseName());
        course.setDepartment(department);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        try {
            courseRepository.delete(course);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
