package com.btl.oracle.services;

import com.btl.oracle.dtos.InstructorDTO;
import com.btl.oracle.dtos.StudentDTO;
import com.btl.oracle.entities.Department;
import com.btl.oracle.entities.Instructor;
import com.btl.oracle.entities.Student;
import com.btl.oracle.exception.ResourceNotFoundException;
import com.btl.oracle.repositories.DepartmentRepository;
import com.btl.oracle.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<InstructorDTO> getAllInstructors() {

        List<Instructor> instructors = instructorRepository.findAll();
        List<InstructorDTO> instructorDTOS = new ArrayList<>();
        for (Instructor s: instructors) {
            InstructorDTO instructorDTO = InstructorDTO.builder()
                    .instructorId(s.getInstructorId())
                    .instructorName(s.getInstructorName())
                    .departmentId(s.getDepartment().getDepartmentId())
                    .departmentName(s.getDepartment().getDepartmentName())
                    .build();
            instructorDTOS.add(instructorDTO);
        }
        return instructorDTOS;
    }

    public Instructor saveInstructor(InstructorDTO req) {
        Department department = departmentRepository.findById(req.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        Instructor instructor = new Instructor(req.getInstructorId(), req.getInstructorName(), department);
        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Long id, Instructor instructorDetails) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));
        instructor.setInstructorName(instructorDetails.getInstructorName());
        instructor.setDepartment(instructorDetails.getDepartment());
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));

        try {
            instructorRepository.delete(instructor);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
