package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @ManyToMany(mappedBy = "medicines")
    private Set<Patient> patients = new HashSet<>();

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
