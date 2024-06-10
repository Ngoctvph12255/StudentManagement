package com.btl.oracle.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.Date;

@Entity
@Table(name = "STUDENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTS_SEQ")
    @SequenceGenerator(allocationSize = 1, name = "STUDENTS_SEQ",sequenceName = "STUDENTS_TRG")
    private Long studentId;

    @NotEmpty(message = "Student name is required")
    @Size(max = 50, message = "Student name must be less than 50 characters")
    private String studentName;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @NotNull(message = "Gender is required")
    @Pattern(regexp = "^$|F|M", message = "Gender must be 'M' or 'F'")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // getters and setters
}
