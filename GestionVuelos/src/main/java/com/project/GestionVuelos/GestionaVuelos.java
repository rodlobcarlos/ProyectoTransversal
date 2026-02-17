package com.project.GestionVuelos;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.project.GestionVuelos.model.Avion;
import com.project.GestionVuelos.model.Vuelo;
import com.project.GestionVuelos.model.VuelosNotFoundException;
import com.project.GestionVuelos.service.AvionService;
import com.project.GestionVuelos.service.VueloService;

@Controller
@RequestMapping("/miweb")
public class GestionaVuelos {

	@Autowired
	private AvionService avionService;
	
	@Autowired
	private VueloService vueloService;

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/avion")
	public ResponseEntity<Avion> addAvion(@RequestBody Avion avion) {
		Avion addedProduct = avionService.createAvion(avion);
		return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
	}
	
	@PutMapping("/avion/{id}")
    public ResponseEntity<Avion> modifyAvion(@PathVariable long id, @RequestBody Avion newAvion) {
		Avion product = avionService.modifyNombreAvion(id, newAvion);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
	
	@DeleteMapping("/aviones/{id}")
    public ResponseEntity<Response> deleteAvion(@PathVariable long id) {
        avionService.deleteAvion(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }
	
	@PostMapping("/vuelo")
	public ResponseEntity<Vuelo> addVuelo(@RequestBody Vuelo vuelo) {
		Vuelo addedVuelo = vueloService.createVuelo(vuelo);
		return new ResponseEntity<>(addedVuelo, HttpStatus.CREATED);
	}
	
	@PutMapping("/vuelo/{id}")
    public ResponseEntity<Vuelo> modifyVuelo(@PathVariable long id, @RequestBody Vuelo newVuelo) {
		Vuelo vuelo = vueloService.modifyNombreVuelo(id, newVuelo);
        return new ResponseEntity<>(vuelo, HttpStatus.OK);
    }
	
	@DeleteMapping("/vuelo/{id}")
    public ResponseEntity<Response> deleteVuelo(@PathVariable long id) {
        avionService.deleteAvion(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
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
