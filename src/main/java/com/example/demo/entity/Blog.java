package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Blog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Blogid;
	private String title;
	private String content;
	private String picId;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Long getId() {
		return Blogid;
	}
	public void setId(Long id) {
		this.Blogid = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicId() {
		return picId;
	}
	public void setPicId(String picId) {
		this.picId = picId;
	}
	public Blog(Long id, String title, String content,String picId) {
		super();
		this.Blogid = id;
		this.title = title;
		this.content = content;
		this.picId=picId;
	}
	public Blog() {
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
