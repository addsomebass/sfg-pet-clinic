package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.BaseEntity;
import com.joevmartin.spring.services.CrudService;

import java.util.Set;

public class BaseEntityServiceMap<T extends BaseEntity> extends AbstractMapService<T, Long> implements CrudService<T, Long> {
	@Override
	public T findById( Long id ) {
		return super.findById( id );
	}

	@Override
	public T save( T model ) {
		return super.save( model.getId(), model );
	}

	@Override
	public Set<T> findAll() {
		return super.findAll();
	}

	@Override
	public void delete( T object ) {
		super.delete( object );
	}

	@Override
	public void deleteById( Long id ) {
		super.deleteById( id );
	}
}
