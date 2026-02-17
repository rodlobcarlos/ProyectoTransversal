package com.project.GestionVuelos.service;

import java.util.List;
import java.util.Optional;

import com.project.GestionVuelos.model.Avion;
import com.project.GestionVuelos.model.Vuelo;

public interface VueloService {

	List<Vuelo> findAll();

	Optional<Vuelo> findById(Long id);

	List<Vuelo> findAllByOrigen(String origen);
	
	public Vuelo createVuelo(Vuelo vuelo);

	public Vuelo modifyNombreVuelo(long id, Vuelo newVuelo);

	void deleteVuelo(long id);
}
