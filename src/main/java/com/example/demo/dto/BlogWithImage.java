package com.example.demo.dto;

import com.example.demo.entity.Blog;

public class BlogWithImage {
	private Blog blog;
	private byte[] image;
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public BlogWithImage() {
		
	}
}
