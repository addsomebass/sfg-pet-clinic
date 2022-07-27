package com.joevmartin.spring.services.springdatajpa;

import com.joevmartin.spring.model.Pet;

import com.joevmartin.spring.repositories.PetRepository;
import com.joevmartin.spring.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile( "springdatajpa" )
public class PetSDJpaService extends BaseSDJpaService<Pet> implements PetService {

	public PetSDJpaService( PetRepository petTypeRepository ) {
		super(petTypeRepository);
	}
}
