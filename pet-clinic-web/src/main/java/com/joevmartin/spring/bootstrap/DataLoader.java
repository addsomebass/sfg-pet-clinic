package com.joevmartin.spring.bootstrap;

import com.joevmartin.spring.model.Owner;
import com.joevmartin.spring.model.Pet;
import com.joevmartin.spring.model.PetType;
import com.joevmartin.spring.model.Vet;
import com.joevmartin.spring.services.OwnerService;
import com.joevmartin.spring.services.PetService;
import com.joevmartin.spring.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;

	public DataLoader( OwnerService ownerService, VetService vetService, PetService petService ) {

		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
	}

	@Override
	public void run( String... args ) throws Exception {

		final Owner joe = new Owner();
		{
			joe.setFirstName( "Joe" );
			joe.setLastName( "Martin" );
			ownerService.save( joe );
		}

		final Owner lb = new Owner();
		{
			lb.setFirstName( "Lora-Beth" );
			lb.setLastName( "Allen" );
			ownerService.save( lb );
		}

		System.out.println("Loaded Owners...");

		{
			final Vet vet = new Vet();
			vet.setFirstName( "Ellie" );
			vet.setLastName( "Belly" );
			vetService.save( vet );
		}
		{
			final Vet vet = new Vet();
			vet.setFirstName( "Fenny" );
			vet.setLastName( "Bo-Benny" );
			vetService.save( vet );
		}

		System.out.println("Vets loaded...");

		{
			final Pet pet = new Pet();
			pet.setOwner( joe );
			pet.setBirthdate( LocalDate.of(2020, 1, 1) );
			final PetType petType = new PetType();
			petType.setName( "Ferret" );
			pet.setPetType( petType );

			petService.save( pet );

		}

	}

}
