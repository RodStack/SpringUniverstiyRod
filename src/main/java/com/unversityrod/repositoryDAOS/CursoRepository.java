package com.unversityrod.repositoryDAOS;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unversityrod.model.Curso;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    List<Curso> findByEspecialidadIdOrderByDescripcionAsc(Integer especialidadId);
    List<Curso> findAllByOrderByDescripcionAsc();
}