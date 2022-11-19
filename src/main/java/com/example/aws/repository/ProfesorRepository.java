package com.example.aws.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.aws.model.Profesor;

@Service
public class ProfesorRepository {
    
    private List<Profesor> profesorList = new ArrayList<>();

    public List<Profesor> getAllProfesors(){
        return profesorList;
    }

    public Profesor getProfesorById(int id){
        for (int i = 0; i < profesorList.size(); i++) {
            if ((profesorList.get(i).getId()) == id) {
                return profesorList.get(i);
            }
        }
        return null;
    }

    public Profesor postProfesor(Profesor profesor){
        Profesor profesorObj = new Profesor();
        profesorObj.setId(profesor.getId());
        profesorObj.setNombres(profesor.getNombres());
        profesorObj.setApellidos(profesor.getApellidos());
        profesorObj.setNumeroEmpleado(profesor.getNumeroEmpleado());
        profesorObj.setHorasClase(profesor.getHorasClase());

        profesorList.add(profesorObj);

        return profesorObj;

    }

    public String deleteProfesor(int id) {
        profesorList.removeIf(x -> (x.getId()) == id);
        return null;
    }

    public Profesor updateProfesor(int idProfesor, Profesor profesor) {
        int idx = 0;
        Profesor profesorObj = new Profesor();

        for (int i = 0; i < profesorList.size(); i++) {
            if ((profesorList.get(i).getId()) == idProfesor) {
                
                idx = i;
                
                profesorObj.setId(idProfesor);
                profesorObj.setNombres(profesor.getNombres());
                profesorObj.setApellidos(profesor.getApellidos());
                profesorObj.setNumeroEmpleado(profesor.getNumeroEmpleado());
                profesorObj.setHorasClase(profesor.getHorasClase());

                profesorList.set(idx, profesorObj);
                break;
            }
        }

        return profesorObj;
    }

  



}

