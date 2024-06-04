package com.btl.oracle.services;

import com.btl.oracle.entities.Student;
import com.btl.oracle.exception.ResourceNotFoundException;
import com.btl.oracle.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        student.setStudentName(studentDetails.getStudentName());
        student.setBirthDate(studentDetails.getBirthDate());
        student.setGender(studentDetails.getGender());
        student.setDepartment(studentDetails.getDepartment());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        studentRepository.delete(student);
    }
}
