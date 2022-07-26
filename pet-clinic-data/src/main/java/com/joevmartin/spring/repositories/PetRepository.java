package com.joevmartin.spring.repositories;

import com.joevmartin.spring.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
