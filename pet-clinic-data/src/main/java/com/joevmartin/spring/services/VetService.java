package com.joevmartin.spring.services;

import com.joevmartin.spring.model.Vet;

import java.util.Set;

public interface VetService {

	Vet findById( Long id);

	Vet save(Vet owner);

	Set<Vet> findAll();
}
