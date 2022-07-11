package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Owner;
import com.joevmartin.spring.model.Pet;
import com.joevmartin.spring.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
	@Override
	public Pet findById( Long aLong ) {
		return super.findById( aLong );
	}

	@Override
	public Pet save( Pet model ) {
		return super.save( model.getId(), model );
	}

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public void delete( Pet object ) {
		super.delete( object );
	}

	@Override
	public void deleteById( Long aLong ) {
		super.deleteById( aLong );
	}
}
