package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import model.Miembros_tripulacion;
import repository.Miembros_tripulacionRepository;

@Service
public class Miembros_tripulacionServiceImpl implements Miembros_tripulacionService {

	private Miembros_tripulacionRepository miembros_tripulacionRepository;

	@Override
	public List<Miembros_tripulacion> findAll() {
		return miembros_tripulacionRepository.findAll();
	}

	@Override
	public Optional<Miembros_tripulacion> findById(Long id) {
		return miembros_tripulacionRepository.findById(id);
	}

}
