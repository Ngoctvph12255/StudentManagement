package com.btl.oracle.repositories;


import com.btl.oracle.dtos.StudentDTO;
import com.btl.oracle.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(
            value = "SELECT * FROM Students",
            countQuery = "SELECT count(*) FROM Students",
            nativeQuery = true)
    Page<Student> findAllUsersWithPagination(Pageable pageable);
}