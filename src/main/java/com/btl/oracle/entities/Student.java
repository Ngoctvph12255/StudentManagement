package com.btl.oracle.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotEmpty(message = "Student name is required")
    @Size(max = 50, message = "Student name must be less than 50 characters")
    private String studentName;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @NotNull(message = "Gender is required")
    @Pattern(regexp = "^[MF]$", message = "Gender must be 'M' or 'F'")
    private char gender;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // getters and setters
}
