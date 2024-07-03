package com.example.demo.controller;

import com.example.demo.dto.MedicineDTO;
import com.example.demo.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<MedicineDTO> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public MedicineDTO getMedicineById(@PathVariable Long id) {
        return medicineService.getMedicineById(id);
    }

    @PostMapping("/{medicineId}/assign/{patientId}")
    public MedicineDTO assignMedicineToPatient(@PathVariable Long medicineId, @PathVariable Long patientId) {
        return medicineService.assignMedicineToPatient(medicineId, patientId);
    }
}
