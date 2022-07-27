package com.joevmartin.spring.controllers;

import com.joevmartin.spring.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetController {

	private final PetService petService;

	public PetController( PetService petServiceMap ) {
		this.petService = petServiceMap;
	}

	@RequestMapping({"/", "", "/index", "/index.html"})
	public String listPets( Model model ) {

		model.addAttribute( "pets", petService.findAll() );

		return "pets/index";

	}
}
