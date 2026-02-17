package com.project.GestionVuelos.service;

import java.util.List;
import java.util.Optional;

import com.project.GestionVuelos.model.Miembros_tripulacion;
import com.project.GestionVuelos.model.Pasajero;

public interface Miembros_tripulacionService {

	List<Miembros_tripulacion> findAll();

	Optional<Miembros_tripulacion> findById(Long id);

	Miembros_tripulacion modifyExperienciaTripulante(long id, Miembros_tripulacion tripulacion);

}
