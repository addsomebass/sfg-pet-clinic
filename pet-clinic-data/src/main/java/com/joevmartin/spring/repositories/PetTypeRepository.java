package com.joevmartin.spring.repositories;

import com.joevmartin.spring.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
