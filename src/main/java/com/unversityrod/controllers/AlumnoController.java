package com.unversityrod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.unversityrod.model.AlumnoCurso;
import com.unversityrod.model.Curso;
import com.unversityrod.model.Especialidad;
import com.unversityrod.repositoryDAOS.AlumnoCursoRepository;
import com.unversityrod.repositoryDAOS.CursoRepository;
import com.unversityrod.repositoryDAOS.EspecialidadRepository;
import java.util.List;

@Controller
@RequestMapping("/")
public class AlumnoController {
    @Autowired
    private CursoRepository cursoRepository;
    
    @Autowired
    private EspecialidadRepository especialidadRepository;
    
    @Autowired
    private AlumnoCursoRepository alumnoCursoRepository;
    
    @GetMapping("/alumnos")
    public String getAlumnos(Model model,
                             @RequestParam(value = "especialidadId", required = false) Integer especialidadId,
                             @RequestParam(value = "cursoId", required = false) Integer cursoId) {
        List<Especialidad> especialidades = especialidadRepository.findAllByOrderByDescripcionAsc();
        model.addAttribute("especialidades", especialidades);

        List<Curso> cursos;
        if (especialidadId != null) {
            cursos = cursoRepository.findByEspecialidadIdOrderByDescripcionAsc(especialidadId);
        } else {
            cursos = cursoRepository.findAllByOrderByDescripcionAsc();
        }
        model.addAttribute("cursos", cursos);

        List<AlumnoCurso> alumnoCursos = null;
        if (cursoId != null) {
            alumnoCursos = alumnoCursoRepository.findByCursoIdOrderByAlumnoNombreAsc(cursoId);
        }
        model.addAttribute("alumnoCursos", alumnoCursos);
        
        model.addAttribute("selectedEspecialidadId", especialidadId);
        model.addAttribute("selectedCursoId", cursoId);

        return "alumnos";
    }
}