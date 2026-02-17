package com.project.GestionVuelos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.GestionVuelos.model.Avion;
import com.project.GestionVuelos.model.Vuelo;
import com.project.GestionVuelos.model.VuelosNotFoundException;
import com.project.GestionVuelos.repository.VueloRepository;

@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	private VueloRepository vueloRepository;

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
