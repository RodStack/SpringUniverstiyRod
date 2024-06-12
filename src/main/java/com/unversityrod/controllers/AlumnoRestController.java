package com.unversityrod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.unversityrod.model.AlumnoCurso;
import com.unversityrod.repositoryDAOS.AlumnoCursoRepository;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AlumnoRestController {

    @Autowired
    private AlumnoCursoRepository alumnoCursoRepository;

    @GetMapping("/alumnos")
    public List<AlumnoCurso> getAlumnos(@RequestParam(value = "cursoId", required = false) Integer cursoId) {
        if (cursoId != null) {
            return alumnoCursoRepository.findByCursoIdOrderByAlumnoNombreAsc(cursoId);
        } else {
            return null; // o retorna un mensaje indicando que se requiere el cursoId
        }
    }
}
