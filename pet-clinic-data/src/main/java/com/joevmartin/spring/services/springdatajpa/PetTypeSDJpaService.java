package com.joevmartin.spring.services.springdatajpa;

import com.joevmartin.spring.model.PetType;
import com.joevmartin.spring.repositories.PetTypeRepository;
import com.joevmartin.spring.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile( "springdatajpa" )
public class PetTypeSDJpaService extends BaseSDJpaService<PetType> implements PetTypeService {


	public PetTypeSDJpaService( PetTypeRepository repository ) {
		super( repository );
	}
}
