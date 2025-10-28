package com.maventech.elocrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ElocrmApplication {

	public static void main(String[] args) {

		try {
			Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		
			dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		} catch (Exception e) {
			System.out.println("Executando sem arquivo .env - usando variáveis de ambiente do sistema.");
		}
	
		SpringApplication.run(ElocrmApplication.class, args);
	
	}

}
