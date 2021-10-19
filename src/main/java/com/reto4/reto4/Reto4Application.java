package com.reto4.reto4;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan(basePackages = {"com.reto4.reto4.modelo"})
@SpringBootApplication
public class Reto4Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto4Application.class, args);
	}

}
