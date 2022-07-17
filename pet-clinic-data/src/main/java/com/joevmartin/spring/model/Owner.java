package com.joevmartin.spring.model;

import java.util.List;

public class Owner extends Person {

	private List<Pet> pets;

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets( List<Pet> pets ) {
		this.pets = pets;
	}
}
