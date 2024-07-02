package com.example.demo.service;

import com.example.demo.dto.VisitDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Visit;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    public List<VisitDTO> getVisitsByPatientId(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return patient.getVisits().stream()
                .map(this::convertToVisitDTO)
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientByVisitId(Long visitId) {
        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new RuntimeException("Visit not found"));
        return convertToPatientDTO(visit.getPatient());
    }

    public List<PatientDTO> getPatientsByVisitDate(LocalDate visitDate) {
        List<Patient> patients = visitRepository.findByVisitDate(visitDate);
        return patients.stream()
                .map(this::convertToPatientDTO)
                .collect(Collectors.toList());
    }

    private VisitDTO convertToVisitDTO(Visit visit) {
        VisitDTO dto = new VisitDTO();
        dto.setId(visit.getId());
        dto.setVisitDate(visit.getVisitDate());
        return dto;
    }

    private PatientDTO convertToPatientDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setVisits(patient.getVisits().stream()
                .map(this::convertToVisitDTO)
                .collect(Collectors.toList()));
        return dto;
    }

}
