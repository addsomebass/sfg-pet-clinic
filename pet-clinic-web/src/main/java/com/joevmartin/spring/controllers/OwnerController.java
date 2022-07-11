package com.joevmartin.spring.controllers;

import com.joevmartin.spring.services.map.OwnerServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

	private final OwnerServiceMap ownerServiceMap;

	public OwnerController( OwnerServiceMap ownerServiceMap ) {
		this.ownerServiceMap = ownerServiceMap;
	}

	@RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
	public String listOwners( Model model ) {

		model.addAttribute( "owners", ownerServiceMap.findAll() );

		return "owners/index";
	}
}
