package com.example.aws.repositories;

import java.util.ArrayList;

import com.example.aws.models.AlumnoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoModel, Integer> {
    public abstract ArrayList<AlumnoModel> findById(int id);
    public abstract ArrayList<AlumnoModel> deleteById(int id);
}
