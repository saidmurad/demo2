package com.example.demo.service;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.entity.Medicine;
import com.example.demo.entity.Patient;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<MedicineDTO> getAllMedicines() {
        return medicineRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MedicineDTO getMedicineById(Long id) {
        return medicineRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public MedicineDTO assignMedicineToPatient(Long medicineId, Long patientId) {
        Medicine medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.getMedicines().add(medicine);
        medicine.getPatients().add(patient);

        patientRepository.save(patient);
        return convertToDTO(medicine);
    }

    private MedicineDTO convertToDTO(Medicine medicine) {
        MedicineDTO dto = new MedicineDTO();
        dto.setId(medicine.getId());
        dto.setName(medicine.getName());
        dto.setType(medicine.getType());
        return dto;
    }

    private PatientDTO convertToDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        return dto;
    }
}
