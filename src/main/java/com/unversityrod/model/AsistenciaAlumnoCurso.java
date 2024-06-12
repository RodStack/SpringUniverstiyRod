package com.unversityrod.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asistencia_alumno_curso")
public class AsistenciaAlumnoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asistencia_alumno_curso")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "alumno_curso_id", nullable = false)
    private AlumnoCurso alumnoCurso;

    @Column(name = "asiste", nullable = false)
    private boolean asiste;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    // Constructor vacío
    public AsistenciaAlumnoCurso() {
    }

    // Constructor con parámetros
    public AsistenciaAlumnoCurso(AlumnoCurso alumnoCurso, boolean asiste, LocalDate fecha) {
        this.alumnoCurso = alumnoCurso;
        this.asiste = asiste;
        this.fecha = fecha;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AlumnoCurso getAlumnoCurso() {
        return alumnoCurso;
    }

    public void setAlumnoCurso(AlumnoCurso alumnoCurso) {
        this.alumnoCurso = alumnoCurso;
    }

    public boolean isAsiste() {
        return asiste;
    }

    public void setAsiste(boolean asiste) {
        this.asiste = asiste;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}