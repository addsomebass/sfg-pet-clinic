package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Person;
import com.joevmartin.spring.services.PersonService;

public class PersonServiceMap<T extends Person> extends BaseEntityServiceMap<T> implements PersonService<T> {
	@Override
	public T findByLastName( String lastName ) {
		return super.findAll().stream().filter( person -> person.getLastName().equals( lastName ) )
				.findAny().orElseThrow( () -> new RuntimeException("Could not find person with last name: " + lastName));
	}
}
