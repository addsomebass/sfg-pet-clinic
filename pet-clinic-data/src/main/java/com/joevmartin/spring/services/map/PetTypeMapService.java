package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.PetType;
import com.joevmartin.spring.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends BaseEntityServiceMap<PetType> implements PetTypeService {

}
