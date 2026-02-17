package com.project.GestionVuelos.service;

import java.util.List;

import com.project.GestionVuelos.model.Pasajero;

public interface PasajeroService {

	List<Pasajero> findAll();

	Pasajero findByPasaporte(String pasaporte);

	Pasajero updatePasajero(long id, Pasajero pasajero);

}
