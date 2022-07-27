package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Pet;
import com.joevmartin.spring.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile( {"default", "map"} )
public class PetServiceMap extends BaseEntityServiceMap<Pet> implements PetService {

}
