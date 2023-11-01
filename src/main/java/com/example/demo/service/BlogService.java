package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Blog;
import com.example.demo.error.BlogNotFoundException;
import com.example.demo.error.UserNotFoundException;

public interface BlogService {
	public Blog saveBlog(Blog b) throws UserNotFoundException;
	public List<Blog> getAllBlog();
	public List<Blog> getUserBlogs(Long userId) throws UserNotFoundException;
	public Blog getParticularBlog(Long blogId) throws BlogNotFoundException;
	public Blog deleteBlog(Long blogId) throws BlogNotFoundException;
}
