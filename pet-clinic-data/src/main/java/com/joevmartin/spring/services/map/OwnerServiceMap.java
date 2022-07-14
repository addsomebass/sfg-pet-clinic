package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Owner;
import com.joevmartin.spring.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceMap extends BaseEntityServiceMap<Owner> implements OwnerService {
	@Override
	public Owner findByLastName( String lastName ) {
		return super.findAll().stream().filter( owner -> owner.getLastName().equals( lastName ) )
				.findAny().orElseThrow( () -> new RuntimeException( "Could not find Owner with last name: " + lastName ) );
	}
}
