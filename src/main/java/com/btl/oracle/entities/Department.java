package com.btl.oracle.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEPARTMENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENTS_SEQ")
    @SequenceGenerator(allocationSize = 1, name = "DEPARTMENTS_SEQ",sequenceName = "DEPARTMENTS_TRG")
    private Long departmentId;

    @NotEmpty(message = "Department name is required")
    @Size(max = 50, message = "Department name must be less than 50 characters")
    private String departmentName;

    // getters and setters
}
