package com.btl.oracle.dtos;

import com.btl.oracle.entities.Department;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDTO {
    private Long courseId;
    private String courseName;
    private Long departmentId;
    private String departmentName;
    @Builder
    public CourseDTO(Long courseId, String courseName, Long departmentId, String departmentName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
}
