package com.btl.oracle.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InstructorDTO {
    private Long instructorId;
    private String instructorName;
    private Long departmentId;
    private String departmentName;

    @Builder
    public InstructorDTO(Long instructorId, String instructorName, Long departmentId, String departmentName) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
}
