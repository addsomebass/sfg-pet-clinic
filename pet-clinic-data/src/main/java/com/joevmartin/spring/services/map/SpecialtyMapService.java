package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Specialty;
import com.joevmartin.spring.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile( {"default", "map"} )
public class SpecialtyMapService extends BaseEntityServiceMap<Specialty> implements SpecialtyService {
}
