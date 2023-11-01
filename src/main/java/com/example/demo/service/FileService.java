package com.example.demo.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Blog;
import com.example.demo.error.FileNotSupportedException;

public interface FileService {
	
	public Blog uploadFiletoServer(MultipartFile file,Blog b) throws FileNotSupportedException;
	public byte[] getFileFromServer(String Picid);
	public void deleteFileFromServer(String Picid) throws IOException;
}
