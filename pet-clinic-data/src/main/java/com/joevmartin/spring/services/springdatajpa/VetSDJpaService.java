package com.joevmartin.spring.services.springdatajpa;

import com.joevmartin.spring.model.Vet;
import com.joevmartin.spring.repositories.VetRepository;
import com.joevmartin.spring.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile( "springdatajpa" )
public class VetSDJpaService implements VetService {

	private VetRepository vetRepository;

	@Override
	public Vet findById( Long id ) {
		return vetRepository.findById( id ).orElse( null );
	}

	@Override
	public Vet save( Vet vet ) {
		return vetRepository.save( vet );
	}

	@Override
	public Set<Vet> findAll() {
		final HashSet<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach( vets::add );
		return vets;
	}

	@Override
	public void delete( Vet vet ) {
		vetRepository.delete( vet );
	}

	@Override
	public void deleteById( Long id ) {
		vetRepository.deleteById( id );
	}

	@Override
	public Vet findByLastName( String lastName ) {
		return vetRepository.findByLastName( lastName );
	}
}
