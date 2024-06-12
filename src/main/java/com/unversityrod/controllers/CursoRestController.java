package com.unversityrod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.unversityrod.model.Curso;
import com.unversityrod.repositoryDAOS.CursoRepository;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CursoRestController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/cursos")
    public List<Curso> getCursos(@RequestParam(value = "especialidadId", required = false) Integer especialidadId) {
        if (especialidadId != null) {
            return cursoRepository.findByEspecialidadIdOrderByDescripcionAsc(especialidadId);
        } else {
            return cursoRepository.findAllByOrderByDescripcionAsc();
        }
    }
}
