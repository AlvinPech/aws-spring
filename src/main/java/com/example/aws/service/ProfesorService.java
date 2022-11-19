package com.example.aws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aws.model.Profesor;
import com.example.aws.repository.ProfesorRepository;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository repository;

    public Profesor postProfesor(Profesor profesor) {
        return repository.postProfesor(profesor);
    }

    public List<Profesor> getAllProfesors() {
        return repository.getAllProfesors();
    }

    public Profesor getProfesorById(int id) {
        return repository.getProfesorById(id);
    }

    public String deleteProfesor(int id) {
        repository.deleteProfesor(id);
        return "Profesor removed !! " + id;
    }

    public Profesor updatProfesor(int id, Profesor profesor) {
       return repository.updateProfesor(id, profesor);
    }
    
}

