package com.project.GestionVuelos.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.GestionVuelos.model.Avion;
import com.project.GestionVuelos.model.VuelosNotFoundException;
import com.project.GestionVuelos.repository.AvionRepository;

@Service
public class AvionServiceImpl implements AvionService {

	@Autowired
	private AvionRepository avionRepository;

	@Override
	public List<Avion> findAll() {
		return avionRepository.findAll();
	}

	@Override
	public Optional<Avion> findById(Long id) {
		return avionRepository.findById(id);
	}

	@Override
	public List<Avion> findAllByNombre(String nombre) {
		return avionRepository.findAllByNombre(nombre);
	}

	@Override
	public Avion createAvion(Avion avion) {
		return avionRepository.save(avion);
	}

	@Override
	public Avion modifyNombreAvion(long id, Avion newAvion) {
		Avion avion = null;
		Optional<Avion> avionOptional = avionRepository.findById(id);
		if (avionOptional.isPresent()) {
			avion = avionOptional.get();
			avion.setNombre(newAvion.getNombre());
		}
		return avion;
	}

	@Override
	public void deleteAvion(long id) {
		if (avionRepository.existsById(id)) {
			avionRepository.deleteById(id);
		} else {
			throw new VuelosNotFoundException("No existe el avión con ID: " + id);
		}
	}
}
