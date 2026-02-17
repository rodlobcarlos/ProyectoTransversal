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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vuelo")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVuelo;

	@JsonProperty("destino")
	@Column(name = "destino")
	private String destino;

	@JsonProperty("origen")
	@Column(name = "origen")
	private String origen;

	@JsonProperty("distancia")
	@Column(name = "distancia")
	private int distancia;

	@JsonProperty("avion")
	@ManyToOne(cascade = CascadeType.MERGE) 
	private Avion avion;
	
	@JsonProperty("pasajeros")
	@OneToMany(cascade = CascadeType.ALL) 
	private List<Pasajero> pasajeros;

	@JsonProperty("miembros_tripulacions")
	@OneToMany(cascade = CascadeType.ALL) 
	private List<Miembros_tripulacion> miembros_tripulacions;

	public long getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(long idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	
}
