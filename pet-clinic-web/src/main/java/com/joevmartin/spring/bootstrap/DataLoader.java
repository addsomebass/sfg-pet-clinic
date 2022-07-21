package com.joevmartin.spring.bootstrap;

import com.joevmartin.spring.model.*;
import com.joevmartin.spring.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;

	public DataLoader( OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtyService specialtyService ) {

		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
	}

	@Override
	public void run( String... args ) throws Exception {

		final int count = petTypeService.findAll().size();

		if ( count == 0 ) {
			loadData();
		}

	}

	private void loadData() {
		final Specialty radiology;
		{
			final Specialty temp = new Specialty();
			temp.setDescription( "Radiology" );
			radiology = specialtyService.save( temp );
		}

		final Specialty surgery;
		{
			final Specialty temp = new Specialty();
			temp.setDescription( "Surgery" );
			surgery = specialtyService.save( temp );
		}

		final Specialty Dentistry;
		{
			final Specialty temp = new Specialty();
			temp.setDescription( "Dentistry" );
			Dentistry = specialtyService.save( temp );
		}

		final PetType ferretType;
		{
			PetType temp = new PetType();
			temp.setName( "Ferret" );
			ferretType = petTypeService.save( temp );
		}


		final PetType dogType;
		{
			PetType temp = new PetType();
			temp.setName( "Dog" );
			dogType = petTypeService.save( temp );
		}


		final Owner joe;
		{
			Owner temp = new Owner();
			temp.setFirstName( "Joe" );
			temp.setLastName( "Martin" );
			joe = ownerService.save( temp );
		}

		final Owner lb;
		{
			Owner temp = new Owner();
			temp.setFirstName( "Lora-Beth" );
			temp.setLastName( "Allen" );
			lb = ownerService.save( temp );
		}

		System.out.println("Loaded Owners...");

		final Vet EllieVet;
		{
			final Vet vet = new Vet();
			vet.setFirstName( "Ellie" );
			vet.setLastName( "Belly" );
			vet.getSpecialties().add( radiology );
			EllieVet = vetService.save( vet );
		}

		final Vet FennyVet;
		{
			final Vet vet = new Vet();
			vet.setFirstName( "Fenny" );
			vet.setLastName( "Bo-Benny" );
			vet.getSpecialties().add( surgery );
			FennyVet = vetService.save( vet );
		}

		System.out.println("Vets loaded...");

		final Pet petFerret;
		{
			final Pet pet = new Pet();
			pet.setOwner( joe );
			pet.setBirthdate( LocalDate.of(2020, 1, 1) );
			pet.setPetType( ferretType );
			petFerret = petService.save( pet );
		}
		joe.getPets().add( petFerret );
		ownerService.save( joe );

		final Pet petDog;
		{
			final Pet pet = new Pet();
			pet.setOwner( lb );
			pet.setBirthdate( LocalDate.of(2020, 1, 1) );
			pet.setPetType( dogType );
			petDog = petService.save( pet );
		}
		lb.getPets().add( petDog );
		ownerService.save( lb );
	}

}
