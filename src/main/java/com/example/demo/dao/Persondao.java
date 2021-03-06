package com.example.demo.dao;

import com.example.demo.model.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Persondao {
	int insertPerson(UUID id, Person person);

	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	List<Person> selectAllPeople();
	Optional SelectPersonById(UUID id);
	int deletePersonById(UUID id);
	int updatePersonById(UUID id,Person person);
}
