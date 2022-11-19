package com.example.aws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.aws.model.Profesor;
import com.example.aws.service.ProfesorService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profesor addProfesor(@RequestBody Profesor profesor) {
        if(validateFields(profesor) != null){
            return service.postProfesor(profesor);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST");
        }
    }

    @GetMapping
    public List<Profesor> findAllProfesor() {
        return service.getAllProfesors();
    }

    @GetMapping(value = "/{id}")
    public Profesor findProfesorById(@PathVariable("id") int id) {         
        if(service.getProfesorById(id) != null){
            return service.getProfesorById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource " + id);
        }
        
        
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Profesor updaProfesor(@PathVariable("id") int id, @RequestBody Profesor profesor) {
        if(validateFields(profesor) != null){
            return service.updatProfesor(id, profesor);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST");
        }
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProfesor(@PathVariable("id") int id) {
        if(service.getProfesorById(id) != null){
            return service.deleteProfesor(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource " + id);
        }
        
    }

    private Profesor validateFields(Profesor profesor){
        if((profesor.getId() instanceof Integer) && profesor.getNombres() instanceof String 
        && profesor.getApellidos() instanceof String && profesor.getNumeroEmpleado() instanceof Integer
        && profesor.getHorasClase() instanceof Integer){
            return profesor;
        }else{
            return null;
        }
    }
}
