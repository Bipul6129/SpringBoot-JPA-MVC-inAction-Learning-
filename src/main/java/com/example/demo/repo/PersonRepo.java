package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.*;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer>{
	public Person findByName(String name);
}
