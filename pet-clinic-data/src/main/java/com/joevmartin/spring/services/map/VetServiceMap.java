package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Vet;
import com.joevmartin.spring.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

	@Override
	public Vet findById( Long aLong ) {
		return super.findById( aLong );
	}

	@Override
	public Vet save( Vet model ) {
		return super.save( model.getId(), model );
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public void delete( Vet object ) {
		super.delete( object );
	}

	@Override
	public void deleteById( Long aLong ) {
		super.deleteById( aLong );
	}

}
