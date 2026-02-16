package model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="pasajero")
public class Pasajero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPasajero;
	
	@Column(name="pasaporte")
	private String pasaporte;
	
	@OneToOne
	private Vuelo vuelo;
}
