package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Pasajero;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {

	List<Pasajero> findAll();

	Pasajero findByPasaporte();
}
