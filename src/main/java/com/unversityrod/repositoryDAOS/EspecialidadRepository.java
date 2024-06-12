package com.unversityrod.repositoryDAOS;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unversityrod.model.Especialidad;
import java.util.List;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
    List<Especialidad> findAllByOrderByDescripcionAsc();
}