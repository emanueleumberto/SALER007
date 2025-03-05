package com.example.SpringDataJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJdbcApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringDataJdbcApplication.class, args);

		// Spring Data JDBC si fa carico della gestione di:
		// -> Apertura della connessione al DB
		// -> Creazione ed esecuzione di PreparedStatement
		// -> Estrazione dei risultati dal ResultSet
		// -> Gestione delle eccezioni
		// -> Chiusura della connessione

	}

}
