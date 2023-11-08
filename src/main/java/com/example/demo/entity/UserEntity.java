package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")

public class UserEntity {
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="userName")
	private String userName;
	
	private int isAdmin;
	private String password;
	private String email;
	private int isBlocked;
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private List<CollegeEntity> colleges;
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private List<CourseEntity> courses;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(int isBlocked) {
		this.isBlocked = isBlocked;
	}

	public List<CollegeEntity> getColleges() {
		return colleges;
	}

	public void setColleges(List<CollegeEntity> colleges) {
		this.colleges = colleges;
	}

	public List<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
