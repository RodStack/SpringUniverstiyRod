package com.unversityrod.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "evaluacion")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluacion_id")
    private Integer id;

    @Column(name = "evaluacion_descripcion", nullable = false, length = 50)
    private String descripcion;

    // Constructor vacío
    public Evaluacion() {
    }

    // Constructor con parámetros
    public Evaluacion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}