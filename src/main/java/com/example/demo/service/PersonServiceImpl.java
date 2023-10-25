package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.repo.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired 
	private PersonRepo personrepo;
	
	@Override
	public Person savePerson(Person p) {
		// TODO Auto-generated method stub
		
		return personrepo.save(p);
	}

	@Override
	public List<Person> viewAll() {
		// TODO Auto-generated method stub
		return personrepo.findAll();
	}

	@Override
	public Person view(Integer id) {
		// TODO Auto-generated method stub
		
		return personrepo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		personrepo.deleteById(id);
	}

	@Override
	public Person update(Integer id, Person p) {
		// TODO Auto-generated method stub
		Person dbPerson = personrepo.findById(id).get();
		
		if(Objects.nonNull(p.getName()) && !"".equalsIgnoreCase(p.getName())) {
			dbPerson.setName(p.getName());
		}
		if(Objects.nonNull(p.getAddress()) && !"".equalsIgnoreCase(p.getAddress())) {
			dbPerson.setAddress(p.getAddress());
		}
		
		
		
		return personrepo.save(dbPerson);
	}

	@Override
	public Person getByName(String name) {
		
		return personrepo.findByName(name);
	}

	
}
