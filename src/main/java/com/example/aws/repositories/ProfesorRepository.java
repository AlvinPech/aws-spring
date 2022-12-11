package com.example.aws.repositories;

import java.util.ArrayList;

import com.example.aws.models.ProfesorModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends CrudRepository<ProfesorModel, Integer> {
    public abstract ArrayList<ProfesorModel> findById(int id);
    public abstract ArrayList<ProfesorModel> deleteById(int id);
}
