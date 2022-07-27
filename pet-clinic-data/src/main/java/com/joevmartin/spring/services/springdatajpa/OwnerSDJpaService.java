package com.joevmartin.spring.services.springdatajpa;

import com.joevmartin.spring.model.Owner;
import com.joevmartin.spring.repositories.OwnerRepository;
import com.joevmartin.spring.repositories.PetRepository;
import com.joevmartin.spring.repositories.PetTypeRepository;
import com.joevmartin.spring.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile( "springdatajpa" )
public class OwnerSDJpaService extends BaseSDJpaService<Owner> implements OwnerService {

	private PetRepository petRepository;
	private PetTypeRepository petTypeRepository;

	public OwnerSDJpaService( OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository ) {
		super(ownerRepository);
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner findByLastName( String lastName ) {
		return ((OwnerRepository)repository).findByLastName(lastName);
	}
}
