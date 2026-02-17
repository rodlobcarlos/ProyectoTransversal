package com.project.GestionVuelos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.GestionVuelos.model.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

	List<Vuelo> findAll();

	Optional<Vuelo> findById(Long id);

	List<Vuelo> findAllByOrigen(String origen);
}
