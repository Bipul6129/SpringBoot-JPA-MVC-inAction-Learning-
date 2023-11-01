package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Blog;
import com.example.demo.error.FileNotSupportedException;

@Service
public class FileServiceImpl implements FileService{
	
	@Value("${upload.dir}")
	private String uploadDir;

	@Override
	public Blog uploadFiletoServer(MultipartFile file,Blog b) throws FileNotSupportedException {
		String originalName = file.getOriginalFilename();
		String saveName=getSaveName(originalName);
		
		try {
			Path uploadPath = Paths.get(uploadDir);
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			Path filePath = uploadPath.resolve(saveName);
			Files.write(filePath,file.getBytes());

			b.setPicId(saveName);
			return b;
		}catch(IOException ex) {
			throw new FileNotSupportedException("problem with file");
		}
		
	}
	
	public String getSaveName(String rawName) throws FileNotSupportedException {
		String saveName="";
		String generatedName= UUID.randomUUID()+".";
		if(rawName!=null) {
			int lastIndex = rawName.lastIndexOf(".");
			if(lastIndex>0) {
				if(!rawName.substring(lastIndex+1).equals("jpg")) {
					throw new FileNotSupportedException("file not supported");
				}
				saveName =generatedName+rawName.substring(lastIndex+1);
			}
			
		}else {
			throw new FileNotSupportedException("file not supported");
		}
		return saveName;
	}

	@Override
	public byte[] getFileFromServer(String Picid) {
		// TODO Auto-generated method stub
		try {
			Path imagePath = Paths.get(uploadDir,Picid);
			return Files.readAllBytes(imagePath);
		}catch(IOException ex) {
			return null;
		}

	}

	@Override
	public void deleteFileFromServer(String Picid) throws IOException {
		Path filePath = Paths.get(uploadDir,Picid);
		Files.deleteIfExists(filePath);
		
	}
	
	

}
