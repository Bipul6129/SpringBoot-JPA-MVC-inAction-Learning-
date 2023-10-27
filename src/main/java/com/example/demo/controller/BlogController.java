package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Blog;
import com.example.demo.error.BlogNotFoundException;
import com.example.demo.service.BlogService;

import jakarta.validation.Valid;

@RestController
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@PostMapping("/save")
	public Blog saveBlog(@Valid @RequestBody Blog b) {
		return blogService.saveBlog(b);
	}
	
	@GetMapping("/blog")
	public List<Blog> getAllBlog(){
		return blogService.getAllBlog();
	}
	
	@GetMapping("/blog/{id}")
	public Blog getById(@PathVariable Integer id) throws BlogNotFoundException {
		return blogService.getById(id);
	}
	
	@PutMapping("/blogUpdate/{id}")
	public Blog updateById(@PathVariable Integer id,@RequestBody Blog b) {
		return blogService.updateBlog(id,b);
	}
	
}
