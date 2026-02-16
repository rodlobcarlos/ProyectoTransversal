package com.project.GestionVuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "acceso.GestionVuelos") // Para que busque notaciones en este paquete
@EnableJpaRepositories(basePackages = "acceso.microservicios.repositorio")
@EntityScan(basePackages = "acceso.microservicios.modelo")
public class GestionVuelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionVuelosApplication.class, args);
	}

}
