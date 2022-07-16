package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Pet;
import com.joevmartin.spring.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends BaseEntityServiceMap<Pet> implements PetService {

}
