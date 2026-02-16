package service;

import java.util.List;
import java.util.Optional;

import model.Miembros_tripulacion;

public interface Miembros_tripulacionService {

	List<Miembros_tripulacion> findAll();

	Optional<Miembros_tripulacion> findById(Long id);
}
