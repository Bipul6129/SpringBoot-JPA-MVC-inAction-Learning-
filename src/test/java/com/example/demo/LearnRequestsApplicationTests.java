package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

@SpringBootTest
class LearnRequestsApplicationTests {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CollegeRepo collegeRepo;
	
	@Autowired
	CourseRepo courseRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	void showAllUser() {
		List<UserEntity> users = userRepo.findAll();
		System.out.println("Test for user");
		for(UserEntity user:users) {
			System.out.print(user.getUserName());
			List<CollegeEntity> colleges=user.getColleges();
			System.out.print(" colleges:");
			for(CollegeEntity college:colleges) {
				System.out.print(" "+college.getCollegeName()+" ");
			}
			System.out.print(" courses:");
			for(CourseEntity course:user.getCourses()) {
				System.out.print(" "+course.getCourseName()+" ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	@Test
	void showCollege() {
		List<CollegeEntity> colleges = collegeRepo.findAll();
		System.out.println("Test for colleges");
		for(CollegeEntity college:colleges) {
			System.out.print(college.getCollegeName()+" "+college.getUser().getUserName());
			for(CourseEntity course: college.getCourses()) {
				System.out.print(" "+course.getCourseName() );
			}
		}
		System.out.println();
	}
	
	@Test
	void showCourse() {
		List<CourseEntity> courses = courseRepo.findAll();
		System.out.println("Test for courses");
		for(CourseEntity course:courses) {
			
			CollegeEntity college = course.getCollege();
			UserEntity user = course.getUser();
			System.out.println(course.getCourseName()+" "+college.getCollegeName()+" "+user.getUserName());
		}
		System.out.println();
	}

}
