package com.joevmartin.spring.controllers;

import com.joevmartin.spring.services.map.PetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {

	private final PetServiceMap petServiceMap;

	public PetController( PetServiceMap petServiceMap ) {
		this.petServiceMap = petServiceMap;
	}

	@RequestMapping({"/pets", "/pets/index", "/pets/index.html"})
	public String listPets( Model model ) {

		model.addAttribute( "pets", petServiceMap.findAll() );

		return "pets/index";

	}
}
