package com.joevmartin.spring.repositories;

import com.joevmartin.spring.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
