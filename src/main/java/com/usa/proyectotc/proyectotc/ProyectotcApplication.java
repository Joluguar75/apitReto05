package com.usa.proyectotc.proyectotc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.usa.proyectotc.proyectotc.model"})
@SpringBootApplication
public class ProyectotcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectotcApplication.class, args);
	}

}
