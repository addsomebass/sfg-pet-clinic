package com.joevmartin.spring.services.springdatajpa;

import com.joevmartin.spring.services.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

public class BaseSDJpaService<T> implements CrudService<T, Long> {

	protected final CrudRepository<T, Long> repository;

	public BaseSDJpaService( CrudRepository<T, Long> repository ) {
		this.repository = repository;
	}

	@Override
	public T findById( Long aLong ) {
		return repository.findById( aLong ).orElse( null );
	}

	@Override
	public T save( T model ) {
		return repository.save( model );
	}

	@Override
	public Set<T> findAll() {
		final HashSet<T> set = new HashSet<>();
		repository.findAll().forEach( set::add );
		return set;
	}

	@Override
	public void delete( T object ) {
		repository.delete( object );

	}

	@Override
	public void deleteById( Long aLong ) {
		repository.deleteById( aLong );

	}
}
