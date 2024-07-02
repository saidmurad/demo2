package com.example.demo.repository;

import com.example.demo.entity.Patient;
import com.example.demo.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query("SELECT v.patient FROM Visit v WHERE v.visitDate = :visitDate")
    List<Patient> findByVisitDate(@Param("visitDate") LocalDate visitDate);

    @Query(value = "SELECT p.name AS name, v.visit_date AS visitDate " +
            "FROM visit v " +
            "JOIN patient p ON v.patient_id = p.id " +
            "WHERE v.visit_date > :visitDate", nativeQuery = true)
    List<Map<String, Object>> findPatientsWithVisitDateAfter(@Param("visitDate") LocalDate visitDate);
}
