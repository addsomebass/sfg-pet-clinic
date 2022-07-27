package com.joevmartin.spring.services.springdatajpa;

import com.joevmartin.spring.model.Specialty;
import com.joevmartin.spring.repositories.SpecialtyRepository;
import com.joevmartin.spring.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Profile( "springdatajpa" )
public class VetSpecialtySDJpaService extends BaseSDJpaService<Specialty> implements SpecialtyService {

	public VetSpecialtySDJpaService( SpecialtyRepository specialtyRepository ) {
		super( specialtyRepository );
	}



}
