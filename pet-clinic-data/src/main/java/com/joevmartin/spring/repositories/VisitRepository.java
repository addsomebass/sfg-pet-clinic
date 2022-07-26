package com.joevmartin.spring.repositories;

import com.joevmartin.spring.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
