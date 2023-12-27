package com.luv2code.springcoredemo.Controller;

import com.luv2code.springcoredemo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Sumit", "Gupta"));
        students.add(new Student("Suresh", "Chandra"));
        students.add(new Student("Shifali", "Gupta"));
        students.add(new Student("Ankit", "Gupta"));
        students.add(new Student("Anita", "Gupta"));
    }

    //define endpoint or "/students" - return all the student details
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    //define endpoint or "/students/{studentId}" - return student at the given index
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return students.get(studentId);
    }
}
