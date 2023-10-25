package com.example.demo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.*;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

import jakarta.validation.Valid;

@RestController
public class PersonController {
	//THis is temp branch edited
	@Autowired
	private PersonService personService;
	
	private final Logger logg = LoggerFactory.getLogger(PersonController.class);
	
	@PostMapping("/save")
	public Person savePerson(@Valid @RequestBody Person p) {
		logg.info("inside the save of post");
		return personService.savePerson(p);
	}
	
	@GetMapping("/viewAll")
	public List<Person> viewAll() {
		return personService.viewAll();
	}
	
	@GetMapping("/view/{id}")
	public Person view(@PathVariable("id") Integer id) {
		
		return personService.view(id); 
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		personService.delete(id);
		return "Deleted succesfully";
	}
	
	@PutMapping("/update/{id}")
	public Person update(@PathVariable("id") Integer id,@RequestBody Person p) {
		return personService.update(id,p);
	}
	
	@GetMapping("/vieww/{name}")
	public Person viewByName(@PathVariable("name") String name) {
		return personService.getByName(name);
	}
}
