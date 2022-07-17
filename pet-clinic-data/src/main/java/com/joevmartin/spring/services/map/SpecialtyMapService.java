package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Specialty;
import com.joevmartin.spring.services.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyMapService extends BaseEntityServiceMap<Specialty> implements SpecialtyService {
}
