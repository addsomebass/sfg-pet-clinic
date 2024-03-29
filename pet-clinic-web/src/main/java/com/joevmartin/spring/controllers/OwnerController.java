package com.joevmartin.spring.controllers;

import com.joevmartin.spring.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

	private final OwnerService ownerService;

	public OwnerController( OwnerService ownerServiceMap ) {
		this.ownerService = ownerServiceMap;
	}

	@RequestMapping({"", "/", "/index", "/index.html"})
	public String listOwners( Model model ) {

		model.addAttribute( "owners", ownerService.findAll() );

		return "owners/index";
	}

	@RequestMapping("/find")
	public String findOwners() {
		return "notimplemented";
	}
}
