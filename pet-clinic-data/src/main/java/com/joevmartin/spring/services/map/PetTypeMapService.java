package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.PetType;
import com.joevmartin.spring.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile( {"default", "map"} )
public class PetTypeMapService extends BaseEntityServiceMap<PetType> implements PetTypeService {

}
