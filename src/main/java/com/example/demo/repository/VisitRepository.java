package com.example.demo.repository;

import com.example.demo.entity.Patient;
import com.example.demo.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query("SELECT v.patient FROM Visit v WHERE v.visitDate = :visitDate")
    List<Patient> findByVisitDate(@Param("visitDate") LocalDate visitDate);
}
