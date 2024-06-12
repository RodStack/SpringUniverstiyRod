package com.unversityrod.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private Integer id;

    @Column(name = "profesor_nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "profesor_email", nullable = false, length = 50)
    private String email;

    // Constructor vacío
    public Profesor() {
    }

    // Constructor con parámetros
    public Profesor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}