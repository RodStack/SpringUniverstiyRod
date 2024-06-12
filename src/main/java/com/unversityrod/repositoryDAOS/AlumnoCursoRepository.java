package com.unversityrod.repositoryDAOS;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unversityrod.model.AlumnoCurso;
import java.util.List;

public interface AlumnoCursoRepository extends JpaRepository<AlumnoCurso, Integer> {
    List<AlumnoCurso> findByCursoIdOrderByAlumnoNombreAsc(Integer cursoId);
}