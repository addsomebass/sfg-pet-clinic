package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Vet;
import com.joevmartin.spring.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends PersonServiceMap<Vet> implements VetService {

}
