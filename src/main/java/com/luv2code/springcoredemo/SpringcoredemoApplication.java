package com.luv2code.springcoredemo;

import com.luv2code.springcoredemo.dao.StudentDAO;
import com.luv2code.springcoredemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao){
		return runner -> {
			createStudents(studentDao);
			retrieveStudent(studentDao);
		};
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

}
