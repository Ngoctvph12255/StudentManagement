package com.btl.oracle.services;

import com.btl.oracle.dtos.EnrollmentDTO;
import com.btl.oracle.entities.Course;
import com.btl.oracle.entities.Department;
import com.btl.oracle.entities.Enrollment;
import com.btl.oracle.entities.Student;
import com.btl.oracle.exception.ResourceNotFoundException;
import com.btl.oracle.repositories.CourseRepository;
import com.btl.oracle.repositories.DepartmentRepository;
import com.btl.oracle.repositories.EnrollmentRepository;
import com.btl.oracle.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<EnrollmentDTO> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        List<EnrollmentDTO> response = new ArrayList<>();
        for (Enrollment e: enrollments) {
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
            enrollmentDTO.setEnrollmentId(e.getEnrollmentId());
            enrollmentDTO.setEnrollmentDate(e.getEnrollmentDate());
            enrollmentDTO.setStudentName(e.getStudent().getStudentName());
            enrollmentDTO.setStudentId(e.getStudent().getStudentId());
            enrollmentDTO.setCourseId(e.getCourse().getCourseId());
            enrollmentDTO.setCourseName(e.getCourse().getCourseName());
            response.add(enrollmentDTO);
        }
        return response;
    }

    public Enrollment saveEnrollment(EnrollmentDTO enrollment) {
        Enrollment enrollmentAdd = new Enrollment();
        Student student = studentRepository.findById(enrollment.getStudentId()).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Course course = courseRepository.findById(enrollment.getCourseId()).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        enrollmentAdd.setStudent(student);
        enrollmentAdd.setCourse(course);
        enrollmentAdd.setEnrollmentDate(enrollment.getEnrollmentDate());
        return enrollmentRepository.save(enrollmentAdd);
    }

    public Enrollment updateEnrollment(Long id, EnrollmentDTO enrollmentDetails) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        Student student = studentRepository.findById(enrollmentDetails.getStudentId()).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Course course = courseRepository.findById(enrollmentDetails.getCourseId()).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(enrollmentDetails.getEnrollmentDate());
        return enrollmentRepository.save(enrollment);
    }

    public void deleteEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));

        try {
            enrollmentRepository.delete(enrollment);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
