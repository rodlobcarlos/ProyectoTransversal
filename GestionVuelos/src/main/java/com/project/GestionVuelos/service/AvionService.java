package com.project.GestionVuelos.service;

import java.util.List;
import java.util.Optional;

import com.project.GestionVuelos.model.Avion;

public interface AvionService {

	List<Avion> findAll();  

	Optional<Avion> findById(Long id);

	List<Avion> findAllByNombre(String nombre);

	public Avion createAvion(Avion avion);

	Avion modifyNombreAvion(long id, Avion newAvion);

	void deleteAvion(long id);

}
