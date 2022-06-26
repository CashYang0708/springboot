package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Persondao;
import com.example.demo.model.Person;

@Service
public class PersonService {
	private final Persondao dao;

	@Autowired
	public PersonService(@Qualifier("fakedao") Persondao dao) {
		this.dao = dao;
	}

	public int addPerson(Person person) {
		return dao.insertPerson(person);
	}
	public List<Person> getAllPeople(){
		return dao.selectAllPeople();
	}
	public Optional<Person> getPersonById(UUID id){
		return dao.SelectPersonById(id);
	}
	public int deletePerson(UUID id) {
		return dao.deletePersonById(id);
	}
	public int updatePerson(UUID id,Person person) {
		return dao.updatePersonById(id, person);
	}
}
