package com.luv2code.springcoredemo;

import com.luv2code.springcoredemo.dao.StudentDAO;
import com.luv2code.springcoredemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao){
		return runner -> {
			createStudents(studentDao);
			//retrieveStudent(studentDao);
			//findAllStudents(studentDao);
			//findStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudentsById(studentDao);
			deleteAllStudents(studentDao);
		};
	}


	private void findStudentsByLastName(StudentDAO studentDao) {
		List<Student> students = studentDao.findByLastName("Gupta");
		for(Student student: students){
			System.out.println(student);
		}
	}

	private void findAllStudents(StudentDAO studentDao) {
		List<Student> students = studentDao.findAll();
		//display all students
		for(Student student: students){
			System.out.println(student);
		}
	}

	private void createStudents(StudentDAO studentDao) {
		Student student1 = new Student("sumit", "gupta", "sumit.gupta810@gmail.,com");
		Student student2 = new Student("ankit", "gupta", "ankit.gupta810@gmail.,com");
		Student student3 = new Student("happy", "gupta", "happy.gupta810@gmail.,com");
		Student student4 = new Student("shashank", "rai", "shashank.rai810@gmail.,com");
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
		studentDao.save(student4);
	}


	private void retrieveStudent(StudentDAO studentDao) {
		Student student3 = new Student("happy", "gupta", "happy.gupta810@gmail.,com");
		studentDao.save(student3);
		System.out.println("Student 3 Id::" +student3.getId());
		Student myStudent = studentDao.findById(student3.getId());
		System.out.println("Found the student: " +myStudent);
	}

	private void updateStudent(StudentDAO studentDao) {
		//retrieve the student with id =1
		int id = 1;
		Student studentId = studentDao.findById(id);
		System.out.println("Update the last name of student Id : 1" +studentId);
		studentId.setLastName("Tiwari");
		//update the last name in DB
		studentDao.update(studentId);
		System.out.println("The updated user :: " +studentId);
	}

	private void deleteStudentsById(StudentDAO studentDao) {
		int id = 1;
		System.out.println("Removing student with id : 1");
		Student theStudent = studentDao.findById(id);
		System.out.println("Student details of id: 1 \n" + theStudent);
		//removing student id:1 from Db
		studentDao.deleteById(theStudent.getId());
	}

	private void deleteAllStudents(StudentDAO studentDao) {
		System.out.println("Deleting all the students");
		int rowsDeleted = studentDao.deleteAll();
		System.out.println("Total numbers of students deleted " + rowsDeleted);
	}

}
