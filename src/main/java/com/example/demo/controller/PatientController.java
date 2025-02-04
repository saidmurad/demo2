package com.example.demo.controller;

import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.VisitDTO;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Visit;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{patientId}/visits")
    public List<VisitDTO> getVisitsByPatientId(@PathVariable Long patientId) {
        return patientService.getVisitsByPatientId(patientId);
    }

    @GetMapping("/visits/{visitId}/patient")
    public PatientDTO getPatientByVisitId(@PathVariable Long visitId) {
        return patientService.getPatientByVisitId(visitId);
    }

    @GetMapping("/visits/date/{visitDate}")
    public List<PatientDTO> getPatientsByVisitDate(@PathVariable String visitDate) {
        LocalDate date = LocalDate.parse(visitDate);
        return patientService.getPatientsByVisitDate(date);
    }

    @GetMapping("/visits")
    public List<Map<String, Object>> getPatientsWithVisitDateAfter(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate visitDate) {
        return patientService.getPatientsWithVisitDateAfter(visitDate);
    }
}
