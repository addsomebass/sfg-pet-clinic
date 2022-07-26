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
public class OwnerSDJpaService implements OwnerService {

	private OwnerRepository ownerRepository;
	private PetRepository petRepository;
	private PetTypeRepository petTypeRepository;

	public OwnerSDJpaService( OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository ) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner findById( Long id ) {

		final Optional<Owner> optionalOwner = ownerRepository.findById( id );

		return optionalOwner.orElse( null );

	}

	@Override
	public Owner save( Owner owner ) {

		ownerRepository.save( owner );
		return null;
	}

	@Override
	public Set<Owner> findAll() {

		final HashSet<Owner> ownersSet = new HashSet<>();
		ownerRepository.findAll().forEach( ownersSet::add );

		return ownersSet;

	}

	@Override
	public void delete( Owner owner ) {

		ownerRepository.delete( owner );

	}

	@Override
	public void deleteById( Long id ) {
		ownerRepository.deleteById( id );
	}

	@Override
	public Owner findByLastName( String lastName ) {
		return ownerRepository.findByLastName(lastName);
	}
}
