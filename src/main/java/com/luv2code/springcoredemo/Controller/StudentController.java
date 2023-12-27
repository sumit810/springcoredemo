package com.luv2code.springcoredemo.Controller;

import com.luv2code.springcoredemo.exceptionHandling.StudentFoundException;
import com.luv2code.springcoredemo.model.Student;
import com.luv2code.springcoredemo.response.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        //check the studentId list
        if(studentId >= students.size() || studentId < 0){
            throw new StudentFoundException("Student id is not found " +studentId);
        }
        return students.get(studentId);
    }
}
