package model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="vuelo")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVuelo;
	
	@Column(name="destino")
	private  String destino;
	
	@Column(name="origen")
	private String origen;
	
	@Column(name="distancia")
	private int distancia;
	
	@OneToOne
	private Avion avion;
	
	@OneToMany
	private List<Pasajero> pasajeros;
	
	@OneToMany
	private List<Miembros_tripulacion> miembros_tripulacions;
}
