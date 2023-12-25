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
			System.out.println("Creating a student object");
			Student student = new Student("Sumit", "Gupta", "sumit.gupta810@gmail.com");

			//save teh student object
			studentDao.save(student);

			//display id of the saved student
			System.out.println("Saved Student. Generated id:: {} " +student.getId());
		};
	}

}
