package com.springmasterclass.study.bai5.repository;

import com.springmasterclass.study.bai5.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // cách 1
    @Query("SELECT p FROM Patient p JOIN FETCH p.checkups")
    List<Patient> findAllWithCheckUp();

    // cách 2
    @EntityGraph(attributePaths = {"checkups"})
    @Query("SELECT p FROM Patient p")
    List<Patient> findAllWithCheckUpOptimized();

    // đây cũng là một cách giải quyết vấn đề N+1 query
    @EntityGraph(attributePaths = {"checkups", "doctors"})
    Page<Patient> findAll(Pageable pageable);

}
