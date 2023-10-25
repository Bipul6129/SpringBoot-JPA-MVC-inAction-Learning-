package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Person;

public interface PersonService {
	public Person savePerson(Person p);
	public List<Person> viewAll();
	public Person view(Integer id);
	public void delete(Integer id);
	public Person update(Integer id, Person p);
	public Person getByName(String name);

}
