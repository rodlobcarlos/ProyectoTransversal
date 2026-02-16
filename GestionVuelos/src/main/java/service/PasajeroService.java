package service;

import java.util.List;

import model.Pasajero;

public interface PasajeroService {

	List<Pasajero> findAll();

	Pasajero findByPasaporte();
}
