package com.project.GestionVuelos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.GestionVuelos.model.Pasajero;
import com.project.GestionVuelos.model.VuelosNotFoundException;
import com.project.GestionVuelos.repository.PasajeroRepository;

@Service
public class PasajeroServiceImpl implements PasajeroService{

	private PasajeroRepository pasajeroRepository;
	
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
		return null;
	}

}
