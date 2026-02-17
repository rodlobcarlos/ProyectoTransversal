package com.project.GestionVuelos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.GestionVuelos.model.Pasajero;
import com.project.GestionVuelos.model.Vuelo;
import com.project.GestionVuelos.model.VuelosNotFoundException;
import com.project.GestionVuelos.repository.PasajeroRepository;
import com.project.GestionVuelos.repository.VueloRepository;

@Service
public class PasajeroServiceImpl implements PasajeroService{

	@Autowired
	private PasajeroRepository pasajeroRepository;
	
	@Autowired
	private VueloRepository vueloRepository;
	
	@Override
	public List<Pasajero> findAll() {
		return pasajeroRepository.findAll();
	}

	@Override
	public Pasajero findByPasaporte(String pasaporte) {
		Pasajero pasajero = pasajeroRepository.findByPasaporte(pasaporte);
		if(pasajero == null) {
			throw new VuelosNotFoundException();
		}
		return pasajero;
	}

	@Override
	public Pasajero updatePasajero(long id, Pasajero pasajeroData) {
	    // 1. Obtenemos la referencia del pasajero que ya existe en la DB
	    Pasajero pasajeroExistente = pasajeroRepository.getReferenceById(id);

	    // 2. Actualizamos el pasaporte con el dato del JSON
	    pasajeroExistente.setPasaporte(pasajeroData.getPasaporte());

	    // 3. Vinculamos al vuelo usando el ID proporcionado en el JSON
	    if (pasajeroData.getVuelo() != null) {
	        Long idVuelo = pasajeroData.getVuelo().getIdVuelo();
	        // Obtenemos la referencia del vuelo para la llave foránea
	        Vuelo vueloReferencia = vueloRepository.getReferenceById(idVuelo);
	        pasajeroExistente.setVuelo(vueloReferencia);
	    }

	    // 4. Guardamos los cambios
	    return pasajeroRepository.save(pasajeroExistente);
	}

}
