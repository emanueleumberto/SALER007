package com.example.GestionePizzeriaJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionePizzeriaJdbcApplication {

	public static void main(String[] args) {

		SpringApplication.run(GestionePizzeriaJdbcApplication.class, args);

		/*
		CREATE TABLE IF NOT EXISTS menu (
			id_menu INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			nome_menu VARCHAR(100) NOT NULL
		);

		CREATE TABLE IF NOT EXISTS prodotti (
			id_prodotto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			nome_prodotto VARCHAR(100) NOT NULL,
			prezzo DECIMAL(10,2) NOT NULL,
			ingredienti_pizza VARCHAR(255) NULL,
			gradi_drink INT NULL,
			menu_id INT NOT NULL,
			tipo_prodotto VARCHAR(100) NOT NULL,
			CONSTRAINT prodotto_menu
				FOREIGN KEY(menu_id)
				REFERENCES menu(id_menu)
				ON DELETE CASCADE ON UPDATE CASCADE
		);
		*/

	}

}
