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
    CONSTRAINT prodotto_menu_fk
		FOREIGN KEY(menu_id)
        REFERENCES menu(id_menu)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS clienti (
	id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(50) NOT NULL,
    telefono_cliente VARCHAR(50) NULL
);

CREATE TABLE IF NOT EXISTS ordini (
	numeroOrdine INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    dataOrdine DATE NOT NULL,
    totale DECIMAL(10,2) NULL
);

CREATE TABLE IF NOT EXISTS prodotti_ordini (
	numeroOrdine INT NOT NULL,
    id_prodotto INT NOT NULL,
    CONSTRAINT ordini_fk
		FOREIGN KEY(numeroOrdine)
        REFERENCES ordini(numeroOrdine)
        ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT prodotti_fk
		FOREIGN KEY(id_prodotto)
        REFERENCES prodotti(id_prodotto)
        ON DELETE CASCADE ON UPDATE CASCADE
);
		*/

	}

}
