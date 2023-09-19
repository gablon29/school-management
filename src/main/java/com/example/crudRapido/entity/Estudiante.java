package com.example.crudRapido.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbStudent")

public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType .IDENTITY)
    private Long estudianteId;
    
    @Column(unique = true, nullable = false)
    private String firstName;

    @Column(unique = true, nullable = false)
    private String lastName;

    @Column(name = "email_address", unique = true, nullable = false)
    private String email;

}