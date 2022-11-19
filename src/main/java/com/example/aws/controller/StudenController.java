package com.example.aws.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.aws.model.Student;
import com.example.aws.service.StudenService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/alumnos")
public class StudenController {

    @Autowired
    private StudenService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        if(validateFields(student) != null){
            return service.postStudent(student);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST");
        }
        
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return service.getStudents();
    }

    @GetMapping(value = "/{id}")
    public Student findStudentById(@PathVariable("id") int id) {         
        if(service.getStudentsById(id) != null){
            return service.getStudentsById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource " + id);
        }
        
        
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        if(validateFields(student) != null){
            return service.updateStudent(id, student);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST");
        }
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteStudent(@PathVariable("id") int id) {
        if(service.getStudentsById(id) != null){
            return service.deleteStudents(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource " + id);
        }
        
    }

    private Student validateFields(Student student){
        if((student.getId() instanceof Integer) && student.getNombres() instanceof String 
        && student.getApellidos() instanceof String && student.getMatricula() instanceof String
        && student.getPromedio() instanceof Double){
            return student;
        }else{
            return null;
        }
    }
}