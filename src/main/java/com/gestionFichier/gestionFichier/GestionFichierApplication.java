package com.gestionFichier.gestionFichier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.UncategorizedMongoDbException;

@SpringBootApplication
public class GestionFichierApplication {

	public static void main(String[] args)throws UncategorizedMongoDbException {
		SpringApplication.run(GestionFichierApplication.class, args);
	}

}
