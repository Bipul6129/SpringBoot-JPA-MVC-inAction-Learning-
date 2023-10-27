package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Blog;
import com.example.demo.error.BlogNotFoundException;
import com.example.demo.repository.BlogRepo;

@Service
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	BlogRepo Blogrepos;

	@Override
	public Blog saveBlog(Blog b) {
		// TODO Auto-generated method stub
		return Blogrepos.save(b);
	}

	@Override
	public List<Blog> getAllBlog() {
		// TODO Auto-generated method stub
		return Blogrepos.findAll();
	}

	@Override
	public Blog getById(Integer id) throws BlogNotFoundException {
		// TODO Auto-generated method stub
		Optional<Blog> b = Blogrepos.findById(id);
		if(!b.isPresent()) {
			throw new BlogNotFoundException("blog not found");
		}
		return b.get();
	}

	@Override
	public Blog updateBlog(Integer id, Blog b) {
		// TODO Auto-generated method stub
		Blog oldBlog = Blogrepos.findById(id).get();
		if(b.getName()!=null && !"".equals(b.getName())) {
			oldBlog.setName(b.getName());
		}
		if(b.getPost()!=null && !"".equals(b.getPost())) {
			oldBlog.setPost(b.getPost());
		}
		
		return Blogrepos.save(oldBlog);
	}
	
	
	
}
