package com.example.demo.controller;

import java.io.IOException;
import com.example.demo.dto.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.*;
import com.example.demo.error.BlogNotFoundException;
import com.example.demo.error.FileNotSupportedException;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.service.BlogService;
import com.example.demo.service.FileService;

@RestController
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	FileService fileService;
	
	@Value("${upload.dir}")
	private String uploadDir;
	
	@PostMapping("/save")
	public Blog saveBlog(@RequestPart("blog") Blog b,@RequestParam("file") MultipartFile file) throws UserNotFoundException, FileNotSupportedException {

		b=(Blog)fileService.uploadFiletoServer(file, b);
		
		return blogService.saveBlog(b);
		
	}
	
	@GetMapping("")
	public List<Blog> allBlogs(){
		return blogService.getAllBlog();
	}
	
	@GetMapping("/userBlogs/{userId}")
	public List<Blog> alluserBlogs(@PathVariable("userId") Long userId) throws UserNotFoundException{
		return blogService.getUserBlogs(userId);
	}
	
	@GetMapping("/{blogId}")
	public BlogWithImage particularBLog(@PathVariable("blogId") Long blogId) throws BlogNotFoundException{
		Blog blog = blogService.getParticularBlog(blogId);
		byte[] imageData = fileService.getFileFromServer(blog.getPicId());
		
		BlogWithImage blogDto = new BlogWithImage();
		blogDto.setBlog(blog);
		blogDto.setImage(imageData);
		return blogDto;
	}
	
	@DeleteMapping("/{blogId}")
	public ResponseEntity<HttpStatus> deleteBlog(@PathVariable("blogId") Long blogId) throws BlogNotFoundException, IOException{
		Blog blog = blogService.deleteBlog(blogId);
		if(blog.getPicId()!=null||!blog.getPicId().trim().equals("")) {
			fileService.deleteFileFromServer(blog.getPicId());
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
