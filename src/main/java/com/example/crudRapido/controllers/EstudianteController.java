package com.example.crudRapido.controllers;

import com.example.crudRapido.entity.Estudiante;
import com.example.crudRapido.service.EstudianteService;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 // yo quisiera hacer una peticion que me devuelva un string por consola que me diga peticion realizada correctamente como lo harias?

@RestController
@RequestMapping(path = "api/v1/estudiantes")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    private final Logger logger = LoggerFactory.getLogger(EstudianteController.class);

    @GetMapping
    public List<Estudiante> getAll() {
        logger.info("Peticion Get realizada con exito");
        return estudianteService.getEstudiantes();
    }
    
    @GetMapping("/{estudianteId}")
    public Optional<Estudiante> getById(@PathVariable("estudianteId") Long estudianteId) {
        logger.info("Peticion realizada con exito");
        return estudianteService.getEstudiante(estudianteId);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Estudiante estudiante) {
        try {
            estudianteService.saveOrUpdate(estudiante);
            logger.info("Peticion Post realizada con exito");
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("Error al procesar la peticion POST", e.getMessage());
        }
            
    }
    @DeleteMapping("/{estudianteId}")
    public void delete(@PathVariable("estudianteId") Long id) {
         estudianteService.delete(id);
    }
    
}
