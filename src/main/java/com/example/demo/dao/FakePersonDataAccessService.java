package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakedao")
public class FakePersonDataAccessService implements Persondao {

	private static List<Person> db = new ArrayList<>();

	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		db.add(new Person(id, person.getName()));
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {
		// TODO Auto-generated method stub
		return db;
	}

	@Override
	public Optional SelectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return db.stream().filter(person -> person.getId().equals(id)).findFirst();
	}

	@Override
	public int deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		Optional<Person> p = SelectPersonById(id);
		if (p.isEmpty()) {
			return 0;
		}
		db.remove(p.get());
		return 1;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		// TODO Auto-generated method stub
		return (int) SelectPersonById(id)
				.map(p->{
					int index=db.indexOf(p);
					if(index>=0) {
						db.set(index, new Person(id, person.getName()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
	}
}


