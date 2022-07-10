package com.joevmartin.spring.services;


import com.joevmartin.spring.model.Pet;

import java.util.Set;

public interface PetService {

	Pet findById( Long id);

	Pet save(Pet owner);

	Set<Pet> findAll();
}
