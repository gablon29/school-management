package com.example.crudRapido.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudRapido.entity.Estudiante;
import com.example.crudRapido.repository.EstudianteRepository;


@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> getEstudiante(Long id) {
        return estudianteRepository.findById(id);
    }

    public void saveOrUpdate(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    public void delete(Long id) {
        estudianteRepository.deleteById(id);
    }
}