package com.example.demo.dto;

import java.util.List;

public class PatientDTO {
    private Long id;
    private String name;
    private List<VisitDTO> visits;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VisitDTO> getVisits() {
        return visits;
    }

    public void setVisits(List<VisitDTO> visits) {
        this.visits = visits;
    }
}
