package com.joevmartin.spring.repositories;

import com.joevmartin.spring.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
