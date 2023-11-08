package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class CourseEntity {
	@Id
	private long course_id;
	private String courseName;
	private String faculty;
	private String semester;
	
	@ManyToOne
	@JoinColumn(name="college_id")
	private CollegeEntity college;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	private long status;

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}


	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public CollegeEntity getCollege() {
		return college;
	}

	public void setCollege(CollegeEntity college) {
		this.college = college;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
