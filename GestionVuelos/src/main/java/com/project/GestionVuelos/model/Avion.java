package com.project.GestionVuelos.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data // Genera getters y setters automáticamente
@NoArgsConstructor // Constructor vacío (obligatorio para JPA)
@AllArgsConstructor // Constructor con todos los campos
@Entity
@Table(name = "avion")
public class Avion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAvion;

	@JsonProperty("nombre")
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "compania")
	private String compania;

	@OneToMany(mappedBy = "avion", cascade = CascadeType.ALL)
	private List<Vuelo> vuelos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Long idAvion) {
		this.idAvion = idAvion;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

}
