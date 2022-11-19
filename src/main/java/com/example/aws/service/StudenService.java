package com.example.aws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aws.model.Student;
import com.example.aws.repository.StudentRepository;

@Service
public class StudenService {
    @Autowired
    private StudentRepository repository;

    public Student postStudent(Student student) {
        return repository.postStudent(student);
    }

    public List<Student> getStudents() {
        return repository.getAllStudents();
    }

    public Student getStudentsById(int id) {
        return repository.getStudentsById(id);
    }

    public String deleteStudents(int id) {
        repository.deleteStudent(id);
        return "student removed !! " + id;
    }

    public Student updateStudent(int id, Student student) {
       return repository.updateStudent(id, student);
    }
    
}
