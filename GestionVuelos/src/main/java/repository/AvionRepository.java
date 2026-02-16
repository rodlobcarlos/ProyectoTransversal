package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {

	List<Avion> findAll();

	Optional<Avion> findById(Long id);

	List<Avion> findAllByNombre(String nombre);
	
	Avion createAvion(Avion avion);
}
