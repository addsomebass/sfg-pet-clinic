package com.joevmartin.spring.bootstrap;

import com.joevmartin.spring.model.Owner;
import com.joevmartin.spring.model.Vet;
import com.joevmartin.spring.services.OwnerService;
import com.joevmartin.spring.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader( OwnerService ownerService, VetService vetService ) {

		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run( String... args ) throws Exception {

		{
			final Owner owner = new Owner();
			owner.setFirstName( "Joe" );
			owner.setLastName( "Martin" );
			owner.setId( 1L );
			ownerService.save( owner );
		}
		{
			final Owner owner = new Owner();
			owner.setFirstName( "Lora-Beth" );
			owner.setLastName( "Allen" );
			owner.setId( 2L );
			ownerService.save( owner );
		}

		System.out.println("Loaded Owners...");

		{
			final Vet vet = new Vet();
			vet.setFirstName( "Ellie" );
			vet.setLastName( "Belly" );
			vet.setId( 1L );
			vetService.save( vet );
		}
		{
			final Vet vet = new Vet();
			vet.setFirstName( "Fenny" );
			vet.setLastName( "Bo-Benny" );
			vet.setId( 2L );
			vetService.save( vet );
		}

		System.out.println("Vets loaded...");

	}

}
