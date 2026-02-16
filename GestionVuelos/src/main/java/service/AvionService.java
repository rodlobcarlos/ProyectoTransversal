package service;

import java.util.List;
import java.util.Optional;

import model.Avion;

public interface AvionService {

	List<Avion> findAll();

	Optional<Avion> findById(Long id);

	List<Avion> findAllByNombre(String nombre);

	public Avion createAvion(Avion avion);
}
