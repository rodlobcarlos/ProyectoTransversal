package com.project.GestionVuelos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.GestionVuelos.model.Avion;
import com.project.GestionVuelos.model.Vuelo;
import com.project.GestionVuelos.model.VuelosNotFoundException;
import com.project.GestionVuelos.repository.AvionRepository;
import com.project.GestionVuelos.repository.VueloRepository;

@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	private VueloRepository vueloRepository;
	
	@Autowired
	private AvionRepository avionRepository;

	@Override
	public List<Vuelo> findAll() {
		return vueloRepository.findAll();
	}

	@Override
	public Optional<Vuelo> findById(Long id) {
		return vueloRepository.findById(id);
	}

	@Override
	public List<Vuelo> findAllByOrigen(String origen) {
		return vueloRepository.findAllByOrigen(origen);
	}

	@Override
	public Vuelo createVuelo(Vuelo vuelo) {
	    // 1. Obtenemos el ID del avión que enviaste en el JSON
	    Long idBuscado = vuelo.getAvion().getIdAvion();

	    // 2. Buscamos el avión. findById devuelve el Optional.
	    // .orElseThrow() extrae el Avion o lanza un error si el ID no existe en la DB.
	    Avion avionReal = avionRepository.findById(idBuscado)
	        .orElseThrow(() -> new RuntimeException("El avión con ID " + idBuscado + " no existe."));

	    // 3. Asignamos el objeto 'avionReal' (que ya está gestionado por JPA) al vuelo
	    vuelo.setAvion(avionReal);

	    // 4. Ahora sí, guardamos el vuelo sin errores de reresencia transitoria
	    return vueloRepository.save(vuelo);
	}

	@Override
	public Vuelo modifyNombreVuelo(long id, Vuelo newVuelo) {
		Vuelo vuelo = null;
		Optional<Vuelo> vueloOpcional = vueloRepository.findById(id);
		if (vueloOpcional.isPresent()) {
			vuelo = vueloOpcional.get();
			vuelo.setIdVuelo(newVuelo.getIdVuelo());
		}
		return vuelo;
	}

	@Override
	public void deleteVuelo(long id) {
		if (vueloRepository.existsById(id)) {
			vueloRepository.deleteById(id);
		} else {
			throw new VuelosNotFoundException(id);
		}
	}

}
