package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Pet;
import com.joevmartin.spring.model.Visit;
import com.joevmartin.spring.repositories.PetRepository;
import com.joevmartin.spring.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceMap extends BaseEntityServiceMap<Visit> implements VisitService {

	private final PetRepository petRepository;

	public VisitServiceMap( PetRepository petRepository ) {
		this.petRepository = petRepository;
	}

	@Override
	public Visit save( Visit model ) {

		if ( model != null && model.getPet() != null && model.getPet().getId() == null ) {
			final Pet save = petRepository.save( model.getPet() );
			model.setPet( save );
		}

		return super.save( model );
	}
}
