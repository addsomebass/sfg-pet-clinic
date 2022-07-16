package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Owner;
import com.joevmartin.spring.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends PersonServiceMap<Owner> implements OwnerService {
}
