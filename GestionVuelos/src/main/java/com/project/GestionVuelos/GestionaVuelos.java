package com.project.GestionVuelos;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.Avion;
import model.VuelosNotFoundException;
import service.AvionService;

@RestController
@Controller
public class GestionaVuelos {

	@Autowired
	private AvionService avionService;

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/avion")
	public ResponseEntity<Avion> addAvion(@RequestBody Avion avion) {
		Avion addedAvion = avionService.createAvion(avion);
		return new ResponseEntity<>(addedAvion, HttpStatus.CREATED);
	}

	@RequestMapping("/lista")
	public String lista(Model model) {
		List<Avion> aviones = avionService.findAll();
		System.out.println(aviones);
		model.addAttribute("productos", aviones);
		return "lista";
	}

	@ExceptionHandler(VuelosNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(VuelosNotFoundException pnfe) {
		Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	// Método para obtener un producto por ID
	@GetMapping("/producto/{id}")
	public ResponseEntity<Optional<Avion>> getAvionById(@PathVariable Long id) {
		Optional<Avion> aviones = avionService.findById(id);
		return ResponseEntity.ok(aviones);
	}

}
