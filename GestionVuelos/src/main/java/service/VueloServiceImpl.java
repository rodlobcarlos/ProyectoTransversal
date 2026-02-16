package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import model.Vuelo;
import repository.VueloRepository;

@Service
public class VueloServiceImpl implements VueloService{

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

}
