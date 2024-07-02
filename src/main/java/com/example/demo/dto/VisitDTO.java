package com.example.demo.dto;

import java.time.LocalDate;

public class VisitDTO {
    private Long id;
    private LocalDate visitDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }
}

