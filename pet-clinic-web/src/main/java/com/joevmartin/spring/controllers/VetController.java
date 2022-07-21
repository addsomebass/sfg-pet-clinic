package com.joevmartin.spring.controllers;

import com.joevmartin.spring.services.map.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

	private final VetServiceMap vetServiceMap;

	public VetController( VetServiceMap vetServiceMap ) {
		this.vetServiceMap = vetServiceMap;
	}

	@RequestMapping({"", "/", "/index", "/index.html", ""})
	public String listVets( Model model){
		model.addAttribute( "vets", vetServiceMap.findAll() );

		return "vets/index";
	}

}
