package com.example.aws.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.aws.model.Student;

@Service
public class StudentRepository {
    
    private List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudents(){
        return studentList;
    }

    public Student getStudentsById(int id){
        for (int i = 0; i < studentList.size(); i++) {
            if ((studentList.get(i).getId()) == id) {
                return studentList.get(i);
            }
        }
        return null;
    }

    public Student postStudent(Student student){
        Student studentObject = new Student();
        studentObject.setId(student.getId());
        studentObject.setNombres(student.getNombres());
        studentObject.setApellidos(student.getApellidos());
        studentObject.setMatricula(student.getMatricula());
        studentObject.setPromedio(student.getPromedio());

        studentList.add(studentObject);

        return studentObject;

    }

    public String deleteStudent(int id) {
        studentList.removeIf(x -> (x.getId()) == id);
        return null;
    }

    public Student updateStudent(int idStudent, Student student) {
        int idx = 0;
        Student studentObject = new Student();

        for (int i = 0; i < studentList.size(); i++) {
            if ((studentList.get(i).getId()) == idStudent) {
                
                idx = i;
                
                studentObject.setId(idStudent);
                studentObject.setNombres(student.getNombres());
                studentObject.setApellidos(student.getApellidos());
                studentObject.setMatricula(student.getMatricula());
                studentObject.setPromedio(student.getPromedio());

                studentList.set(idx, studentObject);
                break;
            }
        }

        

        return studentObject;
    }

  



}
