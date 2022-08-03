package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

	private final long ownerId = 1L;
	OwnerServiceMap ownerServiceMap;

	String lastName = "Martin";

	@BeforeEach
	void setUp() {

		ownerServiceMap = new OwnerServiceMap( new PetTypeServiceMap(), new PetServiceMap() );

		ownerServiceMap.save( Owner.builder().id( ownerId ).lastName( lastName ).build() );
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void findByLastName() {
		final Owner byLastName = ownerServiceMap.findByLastName( lastName );

		assertEquals( lastName, byLastName.getLastName() );


	}

	@Test
	void findById() {

		final Owner byId = ownerServiceMap.findById( ownerId );

		assertEquals( ownerId, byId.getId() );

	}

	@Test
	void findAll() {

		final Set<Owner> all = ownerServiceMap.findAll();

		assertEquals( 1, all.size() );

	}

	@Test
	void delete() {

		ownerServiceMap.delete( ownerServiceMap.findById( ownerId ) );

		assertEquals( 0, ownerServiceMap.findAll().size() );

	}

	@Test
	void deleteById() {

		ownerServiceMap.deleteById( ownerId );

		assertEquals( 0, ownerServiceMap.findAll().size() );
	}

	@Test
	void saveIdPresent() {

		final Owner lb = Owner.builder().id( 2L ).lastName( "Allen" ).build();

		ownerServiceMap.save( lb );

		assertEquals( 2L, ownerServiceMap.findById( 2L ).getId() );


	}

	@Test
	void saveIdNotPresent() {

		final Owner lb = Owner.builder().lastName( "Allen" ).build();

		ownerServiceMap.save( lb );

		assertNotNull( ownerServiceMap.findByLastName( "Allen" ) );
		assertNotNull( ownerServiceMap.findByLastName( "Allen" ).getId() );

	}
}