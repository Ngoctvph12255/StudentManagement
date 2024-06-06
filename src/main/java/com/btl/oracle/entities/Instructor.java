package com.btl.oracle.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "INSTRUCTORS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSTRUCTORS_SEQ")
    @SequenceGenerator(allocationSize = 1, name = "INSTRUCTORS_SEQ",sequenceName = "INSTRUCTORS_TRG")
    private Long instructorId;

    @NotEmpty(message = "Instructor name is required")
    @Size(max = 50, message = "Instructor name must be less than 50 characters")
    private String instructorName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // getters and setters
}
