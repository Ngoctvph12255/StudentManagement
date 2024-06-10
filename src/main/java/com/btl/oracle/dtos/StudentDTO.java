package com.btl.oracle.dtos;

import com.btl.oracle.entities.Department;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import java.util.Date;

@Data
public class StudentDTO {
    private Long studentId;
    private String studentName;
    private Date birthDate;
    private String gender;
    private Long departmentId;
    private String departmentName;
    private String isDelete;
}
