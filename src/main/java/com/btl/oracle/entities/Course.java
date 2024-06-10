package com.btl.oracle.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COURSES")
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_SEQ")
    @SequenceGenerator(allocationSize = 1, name = "COURSE_SEQ",sequenceName = "COURSES_TRG")
    private Long courseId;

    @NotEmpty(message = "Course name is required")
    @Size(max = 50, message = "Course name must be less than 50 characters")
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Builder
    public Course(Long courseId, String courseName, Department department) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
    }
}
