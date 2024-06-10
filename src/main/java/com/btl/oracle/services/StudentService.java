package com.btl.oracle.services;

import com.btl.oracle.dtos.StudentDTO;
import com.btl.oracle.entities.Department;
import com.btl.oracle.entities.Student;
import com.btl.oracle.exception.ResourceNotFoundException;
import com.btl.oracle.repositories.DepartmentRepository;
import com.btl.oracle.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<StudentDTO> getAllStudents() {
        System.out.println("Total students: "+ studentRepository.findAll().size());
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student s: students) {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setStudentId(s.getStudentId());
                studentDTO.setStudentName(s.getStudentName());
                studentDTO.setDepartmentId(Objects.isNull(s.getDepartment()) == true ? 0:s.getDepartment().getDepartmentId());
                studentDTO.setGender(s.getGender());
                studentDTO.setBirthDate(s.getBirthDate());
                studentDTO.setDepartmentName(s.getDepartment().getDepartmentName());
                studentDTO.setIsDelete(s.getDepartment().getDepartmentId() != 0 ? "true":"false");
                studentDTOs.add(studentDTO);
        }
        return studentDTOs;
    }

    public Student saveStudent(StudentDTO student) {
        Department department = departmentRepository.findById(student.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        Student studentEntity = new Student();
        studentEntity.setStudentName(student.getStudentName());
        studentEntity.setGender(student.getGender());
        studentEntity.setBirthDate(student.getBirthDate());
        studentEntity.setDepartment(department);
        return studentRepository.save(studentEntity);
    }

    public Student updateStudent(Long id, StudentDTO studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Department department = departmentRepository.findById(studentDetails.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        student.setStudentName(studentDetails.getStudentName());
        student.setBirthDate(studentDetails.getBirthDate());
        student.setGender(studentDetails.getGender());
        student.setDepartment(department);
        try {
            return studentRepository.save(student);
        }catch (Exception e){
            throw new ResourceNotFoundException("database or pluggable database open for read-only access");
        }
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        studentRepository.delete(student);
    }
}
