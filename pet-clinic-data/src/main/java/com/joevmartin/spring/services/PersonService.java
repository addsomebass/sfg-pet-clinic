package com.joevmartin.spring.services;


import com.joevmartin.spring.model.Person;

public interface PersonService<T extends Person> extends CrudService<T, Long> {
	T findByLastName( String lastName);
}
