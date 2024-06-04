package com.btl.oracle.services;

import com.btl.oracle.entities.Instructor;
import com.btl.oracle.exception.ResourceNotFoundException;
import com.btl.oracle.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor saveInstructor(Instructor instructor) {
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
        instructorRepository.delete(instructor);
    }
}
