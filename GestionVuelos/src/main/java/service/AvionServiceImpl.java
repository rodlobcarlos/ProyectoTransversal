package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import model.Avion;
import repository.AvionRepository;

@Service
public class AvionServiceImpl implements AvionService {

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
		return avionRepository.createAvion(avion);
	}

}
