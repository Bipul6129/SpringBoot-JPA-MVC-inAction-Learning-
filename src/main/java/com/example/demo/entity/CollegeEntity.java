package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="college")
public class CollegeEntity {
	
	@Id
	private long college_id;
	private String collegeName;
	private String location;
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy="college",fetch=FetchType.EAGER)
	private List<CourseEntity> courses; 
	
	public long getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public List<CourseEntity> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}
	public void setCollege_id(long college_id) {
		this.college_id = college_id;
	}
	
	
	
	
}
