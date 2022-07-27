package com.joevmartin.spring.services.springdatajpa;

import com.joevmartin.spring.model.Visit;
import com.joevmartin.spring.repositories.VisitRepository;
import com.joevmartin.spring.services.VisitService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile( "springdatajpa" )
public class VisitSDJpaService extends BaseSDJpaService<Visit> implements VisitService {


	public VisitSDJpaService( VisitRepository repository ) {
		super( repository );
	}
}
