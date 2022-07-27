package com.joevmartin.spring.services.springdatajpa;

import com.joevmartin.spring.model.Visit;
import com.joevmartin.spring.repositories.VisitRepository;
import com.joevmartin.spring.services.VisitService;
import org.springframework.data.repository.CrudRepository;

public class VisitSDJpaService extends BaseSDJpaService<Visit> implements VisitService {


	public VisitSDJpaService( VisitRepository repository ) {
		super( repository );
	}
}
