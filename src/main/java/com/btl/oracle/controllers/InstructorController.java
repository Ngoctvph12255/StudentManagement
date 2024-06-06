package com.btl.oracle.controllers;

import com.btl.oracle.entities.Instructor;
import com.btl.oracle.services.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @PostMapping
    public Instructor createInstructor(@Valid @RequestBody Instructor instructor) {
        return instructorService.saveInstructor(instructor);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable Long id,@Valid @RequestBody Instructor instructorDetails) {
        return instructorService.updateInstructor(id, instructorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
    }
}
