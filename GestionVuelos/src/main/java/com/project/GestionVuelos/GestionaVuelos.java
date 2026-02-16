package com.project.GestionVuelos;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.model.Model;
import model.Avion;
import service.AvionService;

@RestController
public class GestionaVuelos {

	@Autowired
	private AvionService avionService;
	@RequestMapping(value = "/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/avion")
	public String catalog(Model model) {
		List<Avion> aviones = avionService.findAll();
		model.addAttribute("aviones", aviones);
		return "avion";
	}

}
