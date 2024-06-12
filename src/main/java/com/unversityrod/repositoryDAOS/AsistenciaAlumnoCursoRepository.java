package com.unversityrod.repositoryDAOS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unversityrod.model.AsistenciaAlumnoCurso;

@Repository
public interface AsistenciaAlumnoCursoRepository extends JpaRepository<AsistenciaAlumnoCurso, Integer>{

}
