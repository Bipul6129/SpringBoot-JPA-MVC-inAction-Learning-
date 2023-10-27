package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Blog;
import com.example.demo.error.BlogNotFoundException;

public interface BlogService {
	public Blog saveBlog(Blog b);

	public List<Blog> getAllBlog();

	public Blog getById(Integer id) throws BlogNotFoundException;

	public Blog updateBlog(Integer id, Blog b);
}
