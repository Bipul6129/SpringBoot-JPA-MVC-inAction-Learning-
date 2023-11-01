package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Blog;
import com.example.demo.entity.User;
import com.example.demo.error.BlogNotFoundException;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.repository.BlogRepo;
import com.example.demo.repository.UserRepo;

@Service
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	BlogRepo blogRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public Blog saveBlog(Blog b) throws UserNotFoundException {
		if(userRepo.findById(b.getUser().getId()).isEmpty()) {
			throw new UserNotFoundException("user does not exist");
		}
		return blogRepo.save(b);
	}

	@Override
	public List<Blog> getAllBlog() {
		// TODO Auto-generated method stub
		return blogRepo.findAll();
	}

	@Override
	public List<Blog> getUserBlogs(Long userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> users = userRepo.findById(userId);
		if(users.isEmpty()) {
			throw new UserNotFoundException("user not present");
		}
		User u = users.get();
		return u.getBlogs();
	}

	@Override
	public Blog getParticularBlog(Long blogId) throws BlogNotFoundException {
		Optional<Blog> blogs = blogRepo.findById(blogId);
		if(blogs.isEmpty()) {
			throw new BlogNotFoundException("blog not found");
		}
		Blog b = blogs.get();
		return b;
	}

	@Override
	public Blog deleteBlog(Long blogId) throws BlogNotFoundException {
		// TODO Auto-generated method stub
		Optional<Blog> blogs = blogRepo.findById(blogId);
		if(blogs.isEmpty()) {
			throw new BlogNotFoundException("blog not found");
		}

		blogRepo.deleteById(blogId);
		return blogs.get();
	}
	
	
	
}
