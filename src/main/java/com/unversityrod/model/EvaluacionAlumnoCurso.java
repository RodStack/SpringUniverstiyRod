package com.unversityrod.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "evaluacion_alumno_curso")
public class EvaluacionAlumnoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluacion_alumno_curso")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "alumno_curso_id", nullable = false)
    private AlumnoCurso alumnoCurso;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id", nullable = false)
    private Evaluacion evaluacion;

    @Column(name = "nota", nullable = false)
    private double nota;

    // Constructor vacío
    public EvaluacionAlumnoCurso() {
    }

    // Constructor con parámetros
    public EvaluacionAlumnoCurso(AlumnoCurso alumnoCurso, Evaluacion evaluacion, double nota) {
        this.alumnoCurso = alumnoCurso;
        this.evaluacion = evaluacion;
        this.nota = nota;
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

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}