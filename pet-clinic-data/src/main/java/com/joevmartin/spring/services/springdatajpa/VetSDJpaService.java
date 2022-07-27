package com.joevmartin.spring.services.springdatajpa;

import com.joevmartin.spring.model.Vet;
import com.joevmartin.spring.repositories.VetRepository;
import com.joevmartin.spring.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile( "springdatajpa" )
public class VetSDJpaService extends BaseSDJpaService<Vet> implements VetService {

	public VetSDJpaService( VetRepository repository ) {
		super( repository );
	}


	@Override
	public Vet findByLastName( String lastName ) {
		return ((VetRepository)repository).findByLastName( lastName );
	}
}
