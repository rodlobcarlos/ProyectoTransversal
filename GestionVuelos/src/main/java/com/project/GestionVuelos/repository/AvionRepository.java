package com.project.GestionVuelos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.GestionVuelos.model.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {

	List<Avion> findAll();

	Optional findById(long id);

	List<Avion> findAllByNombre(String nombre);
	
}
