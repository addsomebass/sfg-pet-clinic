package com.joevmartin.spring.services.map;

import com.joevmartin.spring.model.Owner;
import com.joevmartin.spring.model.Pet;
import com.joevmartin.spring.services.OwnerService;
import com.joevmartin.spring.services.PetService;
import com.joevmartin.spring.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile( {"default", "map"} )
public class OwnerServiceMap extends PersonServiceMap<Owner> implements OwnerService {

	private PetTypeService petTypeService;
	private PetService petService;

	public OwnerServiceMap( PetTypeService petTypeService, PetService petService ) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner save( Owner model ) {

		if ( model != null ) {
			if ( model.getPets() != null ) {

				model.getPets().forEach( pet -> {
					if ( pet.getPetType() != null) {
						if( pet.getPetType().getId() == null) {
							pet.setPetType( petTypeService.save( pet.getPetType() ) );
						}
					}

					if (pet.getId() == null) {
						final Pet savedPet = petService.save( pet );
						pet.setId( savedPet.getId() );
					}
				});
			}
		}

		return super.save( model );
	}
}
