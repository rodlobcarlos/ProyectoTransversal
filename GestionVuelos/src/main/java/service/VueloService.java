package service;

import java.util.List;
import java.util.Optional;

import model.Vuelo;

public interface VueloService {

	List<Vuelo> findAll();

	Optional<Vuelo> findById(Long id);

	List<Vuelo> findAllByOrigen(String origen);
}
