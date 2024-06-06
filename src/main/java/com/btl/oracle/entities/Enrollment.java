package com.btl.oracle.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name ="ENROLLMENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENROLLMENTS_SEQ")
    @SequenceGenerator(allocationSize = 1, name = "ENROLLMENTS_SEQ",sequenceName = "ENROLLMENTS_TRG")
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    @NotNull(message = "Enrollment date is required")
    @Temporal(TemporalType.DATE)
    private Date enrollmentDate;

    // getters and setters
}
