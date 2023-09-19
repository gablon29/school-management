package com.example.crudRapido.controllers;

import com.example.crudRapido.entity.Estudiante;
import com.example.crudRapido.service.EstudianteService;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/estudiantes")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> getAll() {
        return estudianteService.getEstudiantes();
    }
    
    @GetMapping("/{estudianteId}")
    public Optional<Estudiante> getById(@PathVariable("estudianteId") Long estudianteId) {
        return estudianteService.getEstudiante(estudianteId);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Estudiante estudiante) {
         estudianteService.saveOrUpdate(estudiante);
    }
    @DeleteMapping("/{estudianteId}")
    public void delete(@PathVariable("estudianteId") Long id) {
         estudianteService.delete(id);
    }
    
}
