package com.joevmartin.spring.controllers;

import com.joevmartin.spring.model.Owner;
import com.joevmartin.spring.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.HashSet;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith( MockitoExtension.class )
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;

	@InjectMocks
	OwnerController ownerController;

	HashSet<Owner> owners;
	private MockMvc mockMvc;


	@BeforeEach
	void setUp() {
		 owners = new HashSet<Owner>();

		owners.add(Owner.builder().id( 1L ).build());
		owners.add(Owner.builder().id( 2L ).build());
		owners.add(Owner.builder().id( 3L ).build());

		mockMvc = MockMvcBuilders.standaloneSetup( ownerController ).build();

	}

	@Test
	void listOwners() throws Exception {

		when(ownerService.findAll()).thenReturn( owners );

		mockMvc.perform( get("/owners") )
				.andExpect( status().isOk() )
				.andExpect( view().name( "owners/index" ) )
				.andExpect( model().attribute( "owners", hasSize(3) ) );


	}
	@Test
	void listOwnersByIndex() throws Exception {

		when(ownerService.findAll()).thenReturn( owners );

		mockMvc.perform( get("/owners/index") )
				.andExpect( status().isOk() )
				.andExpect( view().name( "owners/index" ) )
				.andExpect( model().attribute( "owners", hasSize(3) ) );


	}

	@Test
	void findOwners() throws Exception {

		mockMvc.perform( get("/owners/find") )
				.andExpect( status().isOk() )
				.andExpect( view().name( "notimplemented" ) );

		verifyNoInteractions( ownerService );

	}
}