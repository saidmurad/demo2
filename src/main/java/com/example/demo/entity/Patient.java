package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Visit> visits = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "patient_medicine",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id")
    )
    private Set<Medicine> medicines = new HashSet<>();

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

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(Set<Medicine> medicines) {
        this.medicines = medicines;
    }
}
