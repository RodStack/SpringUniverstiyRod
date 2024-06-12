package com.unversityrod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.unversityrod.model.Especialidad;
import com.unversityrod.repositoryDAOS.EspecialidadRepository;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EspecialidadRestController {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @GetMapping("/especialidades")
    public List<Especialidad> getEspecialidades() {
        return especialidadRepository.findAllByOrderByDescripcionAsc();
    }
}