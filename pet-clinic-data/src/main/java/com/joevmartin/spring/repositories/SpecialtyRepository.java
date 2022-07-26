package com.joevmartin.spring.repositories;

import com.joevmartin.spring.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
