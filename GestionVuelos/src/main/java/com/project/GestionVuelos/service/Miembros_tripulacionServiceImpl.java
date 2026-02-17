package com.project.GestionVuelos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.GestionVuelos.model.Miembros_tripulacion;
import com.project.GestionVuelos.model.Vuelo;
import com.project.GestionVuelos.repository.Miembros_tripulacionRepository;

@Service
public class Miembros_tripulacionServiceImpl implements Miembros_tripulacionService {

	@Autowired
	private Miembros_tripulacionRepository miembros_tripulacionRepository;

	@Override
	public List<Miembros_tripulacion> findAll() {
		return miembros_tripulacionRepository.findAll();
	}

	@Override
	public Optional<Miembros_tripulacion> findById(Long id) {
		return miembros_tripulacionRepository.findById(id);
	}

	@Override
	public Miembros_tripulacion modifyExperienciaTripulante(long id, Miembros_tripulacion tripulacion) {
		Miembros_tripulacion miembros_tripulacion = miembros_tripulacionRepository.findById(id);

		miembros_tripulacion.setExperiencia(tripulacion.getExperiencia());
		return miembros_tripulacionRepository.save(miembros_tripulacion);
	}

}
