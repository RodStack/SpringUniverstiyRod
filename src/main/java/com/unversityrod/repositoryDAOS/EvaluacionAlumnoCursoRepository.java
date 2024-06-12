package com.unversityrod.repositoryDAOS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unversityrod.model.EvaluacionAlumnoCurso;

@Repository
public interface EvaluacionAlumnoCursoRepository extends JpaRepository<EvaluacionAlumnoCurso, Integer>{
	@Query("SELECT c.descripcion AS cursoDescripcion, eac.nota AS nota " +
	           "FROM EvaluacionAlumnoCurso eac " +
	           "JOIN AlumnoCurso ac ON eac.alumnoCurso.id = ac.id " +
	           "JOIN Curso c ON ac.curso.id = c.id " +
	           "WHERE ac.alumno.id = :alumnoId")
	    List<Object[]> findCursosYNotasPorAlumno(@Param("alumnoId") Integer alumnoId);
}
