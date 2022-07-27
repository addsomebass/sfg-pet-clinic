package com.joevmartin.spring.controllers;

import com.joevmartin.spring.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

	private final VetService vetService;

	public VetController( VetService vetServiceMap ) {
		this.vetService = vetServiceMap;
	}

	@RequestMapping({"", "/", "/index", "/index.html", ""})
	public String listVets( Model model){
		model.addAttribute( "vets", vetService.findAll() );

		return "vets/index";
	}

}
