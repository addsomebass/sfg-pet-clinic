package com.joevmartin.spring.services.springdatajpa;

import com.joevmartin.spring.model.Owner;
import com.joevmartin.spring.repositories.OwnerRepository;
import com.joevmartin.spring.repositories.PetRepository;
import com.joevmartin.spring.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
class OwnerSDJpaServiceTest {

	private static final String ownerLastName = "Martin";
	private final long id = 1L;
	final Owner returnOwner = Owner.builder().id( id ).lastName( ownerLastName ).build();


	@Mock
	OwnerRepository ownerRepository;

	@Mock
	PetRepository petRepository;

	@Mock
	PetTypeRepository petTypeRepository;

	@InjectMocks
	OwnerSDJpaService service;

	@BeforeEach
	void setUp() {

	}

	@Test
	void findById() {

		when(ownerRepository.findById( any() )).thenReturn( Optional.of( returnOwner ) );

		final Owner byId = service.findById( id );

		assertNotNull( byId );
		assertEquals( id, byId.getId() );

		verify( ownerRepository ).findById( any() );

	}

	@Test
	void save() {

		when( ownerRepository.save( returnOwner ) ).thenReturn( Owner.builder().id( returnOwner.getId() + 1 ).lastName( returnOwner.getLastName() ).build() );

		final Owner save = service.save( returnOwner );

		assertEquals( returnOwner.getId() + 1, save.getId() );

		verify( ownerRepository ).save( returnOwner );

	}

	@Test
	void findAll() {


		final HashSet<Owner> owners = new HashSet<>();
		owners.add( returnOwner );
		owners.add( Owner.builder().id( 2L ).lastName( "Allen" ).build() );

		when(ownerRepository.findAll()).thenReturn( owners );


		final Set<Owner> all = service.findAll();

		assertEquals( owners.size(), all.size() );
		verify( ownerRepository ).findAll();


	}

	@Test
	void delete() {

		service.delete( returnOwner );

		verify( ownerRepository ).delete( returnOwner );

	}

	@Test
	void deleteById() {

		service.deleteById( id );

		verify( ownerRepository ).deleteById( id );

	}

	@Test
	void findByLastName() throws InterruptedException {

		when(ownerRepository.findByLastName( any() )).thenReturn( returnOwner );

		final Owner martin = service.findByLastName( ownerLastName );

		assertEquals( ownerLastName, martin.getLastName());

		verify( ownerRepository, timeout( 0 ).times( 1 ) ).findByLastName( any() );


	}
}