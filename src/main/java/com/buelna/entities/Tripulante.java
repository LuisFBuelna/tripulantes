package com.buelna.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "tripulante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tripulante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;

    @Column(name = "registered_at")
    private Date registeredAt;

    public Tripulante(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Tripulante(String name, String role, Date registeredAt) {
        this.name = name;
        this.role = role;
        this.registeredAt = registeredAt;
    }
}
