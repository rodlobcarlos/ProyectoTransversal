package com.project.GestionVuelos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.GestionVuelos.model.Miembros_tripulacion;

@Repository
public interface Miembros_tripulacionRepository extends JpaRepository<Miembros_tripulacion, Long>{

	List<Miembros_tripulacion> findAll();
	
	Optional<Miembros_tripulacion> findById(Long id);
}
