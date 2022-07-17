package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Specialty;
import com.joevmartin.spring.model.Vet;
import com.joevmartin.spring.services.SpecialtyService;
import com.joevmartin.spring.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends PersonServiceMap<Vet> implements VetService {

	private SpecialtyService specialtyService;

	public VetServiceMap( SpecialtyService specialtyService ) {
		this.specialtyService = specialtyService;
	}

	@Override
	public Vet save( Vet model ) {

		if ( model != null ) {
			if ( model.getSpecialties() != null ) {
				model.getSpecialties().forEach( specialty -> {
					if ( specialty.getId() == null ) {
						final Specialty save = specialtyService.save( specialty );
						specialty.setId( save.getId() );
					}
				} );
			}
		}

		return super.save( model );
	}
}
