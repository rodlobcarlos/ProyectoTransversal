package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Pasajero;
import model.VuelosNotFoundException;
import repository.PasajeroRepository;

@Service
public class PasajeroServiceImpl implements PasajeroService{

	private PasajeroRepository pasajeroRepository;
	
	@Override
	public List<Pasajero> findAll() {
		return pasajeroRepository.findAll();
	}

	@Override
	public Pasajero findByPasaporte() {
		Pasajero pasajero = pasajeroRepository.findByPasaporte();
		if(pasajero == null) {
			throw new VuelosNotFoundException();
		}
		return null;
	}

}
