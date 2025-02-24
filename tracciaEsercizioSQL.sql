/*
Esercizio: Creazione e Gestione della Struttura di un Database
Obiettivo: Applicare le istruzioni DDL per creare e modificare la struttura di un database MySQL.

Scenario:
Sei il database administrator di un'azienda che gestisce una libreria online. 
Ti viene chiesto di creare il database e le relative tabelle per gestire libri, autori e utenti.

Compiti da svolgere:
    1. Creare il database chiamato LibraryDB.
    2. Selezionare il database per l'uso.
    3. Creare la tabella Authors con i seguenti campi:
        author_id (INT, chiave primaria, autoincrementata)
        name (VARCHAR(100), non nullo)
        birth_year (INT, può essere nullo)
    4. Creiamo le seguenti relazioni
        One-to-One (1:1) → Relazione tra Utenti e Dettagli Utente
			Creare la tabella Users con i seguenti campi:
				user_id (INT, chiave primaria, autoincrementata)
                name (VARCHAR(255))
                email (VARCHAR(255))
            Ogni utente ha un solo profilo con dettagli aggiuntivi.
            Creiamo una tabella UserDetails con chiave primaria condivisa.
                user_id (INT, chiave primaria, autoincrementata)
                address (VARCHAR(255))
                phone_number (VARCHAR(15))
        One-to-Many (1:N) → Relazione tra Autori e Libri
            Un autore può scrivere più libri, ma un libro ha un solo autore.
            Creare la tabella Books con i seguenti campi:
                book_id (INT, chiave primaria, autoincrementata)
                title (VARCHAR(255), non nullo)
                publication_year (INT, può essere nullo)
                author_id (INT, chiave esterna che fa riferimento a Authors)
        Many-to-Many (M:N) → Relazione tra Libri e Utenti (Prestiti)
            Un utente può prendere in prestito più libri, e un libro può essere 
            preso in prestito da più utenti.
            Per gestire questa relazione, creiamo una tabella di collegamento (Loans).
                loan_id (INT, chiave primaria, autoincrementata)
                user_id (INT, non nullo)
                book_id (INT, non nullo)
                loan_date (DATE, non nullo)
                return_date (DATE, può essere nullo)
    5. Modificare la tabella Books aggiungendo una colonna genre (VARCHAR(50)).
    6. Aggiungere una colonna "ISBN" alla tabella Books
    7. Modificare il tipo di dato della colonna birth_year in Authors per accettare 
       solo date  di tipo YEAR.
    8. Modificare il tipo di dato di "phone_number" in UserDetails in CHAR
    9. Eliminare la colonna genre dalla tabella Books.
    10. Eliminare la colonna "birth_year" dalla tabella Authors
    11. Eliminare la tabella Authors.
    12. Eliminare il database LibraryDB.

    
*/

-- Soluzione

-- 1. Creare il database chiamato LibraryDB.
CREATE DATABASE IF NOT EXISTS librarydb;

-- 2. Selezionare il database per l'uso.
USE librarydb;

-- 3. Creare la tabella Authors con i seguenti campi:
--      author_id (INT, chiave primaria, autoincrementata)
--      name (VARCHAR(100), non nullo)
--		birth_year (INT, può essere nullo)

CREATE TABLE IF NOT EXISTS librarydb.authors (
	author_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birth_year INT NOT NULL
);

-- 4. Creiamo le seguenti relazioni
-- One-to-One (1:1) → Relazione tra Utenti e Dettagli Utente
-- Ogni utente ha un solo profilo con dettagli aggiuntivi.
/*	Creare la tabella Users con i seguenti campi:
		user_id (INT, chiave primaria, autoincrementata)
		name (VARCHAR(255))
		email (VARCHAR(255))
*/
CREATE TABLE IF NOT EXISTS librarydb.users(
	user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(15) NOT NULL UNIQUE
);

/* Creiamo una tabella UserDetails con chiave primaria condivisa.
		user_id (INT, chiave primaria, autoincrementata)
		address (VARCHAR(255))
		phone_number (VARCHAR(15))
*/
CREATE TABLE IF NOT EXISTS librarydb.userdetails(
	user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    CONSTRAINT users_userdetails_fk FOREIGN KEY(user_id) 
		REFERENCES librarydb.users(user_id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- One-to-Many (1:N) → Relazione tra Autori e Libri
-- Un autore può scrivere più libri, ma un libro ha un solo autore.
/* Creare la tabella Books con i seguenti campi:
		book_id (INT, chiave primaria, autoincrementata)
		title (VARCHAR(255), non nullo)
		publication_year (INT, può essere nullo)
		author_id (INT, chiave esterna che fa riferimento a Authors)
*/
CREATE TABLE IF NOT EXISTS librarydb.books (
	book_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    publication_year INT NULL,
    author_id INT NOT NULL,
    CONSTRAINT books_authors_fk FOREIGN KEY(author_id) 
		REFERENCES librarydb.authors(author_id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Many-to-Many (M:N) → Relazione tra Libri e Utenti (Prestiti)
-- Un utente può prendere in prestito più libri, e un libro può essere preso in prestito da più utenti.
/* Per gestire questa relazione, creiamo una tabella di collegamento (Loans).
		loan_id (INT, chiave primaria, autoincrementata)
		user_id (INT, non nullo)
		book_id (INT, non nullo)
		loan_date (DATE, non nullo)
		return_date (DATE, può essere nullo)
*/
CREATE TABLE IF NOT EXISTS librarydb.loans (
	loan_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE NULL,
    CONSTRAINT users_loans_fk FOREIGN KEY(user_id) 
		REFERENCES librarydb.users(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT books_loans_fk FOREIGN KEY(book_id) 
		REFERENCES librarydb.books(book_id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 5. Modificare la tabella Books aggiungendo una colonna genre (VARCHAR(50)).
ALTER TABLE librarydb.books ADD COLUMN genre VARCHAR(50) NULL;

-- 6. Aggiungere una colonna "ISBN" alla tabella Books
ALTER TABLE librarydb.books ADD COLUMN isbn CHAR(10) NOT NULL UNIQUE;

-- 7. Modificare il tipo di dato della colonna birth_year in Authors per accettare solo date  di tipo YEAR.
ALTER TABLE librarydb.authors MODIFY birth_year YEAR;

-- 8. Modificare il tipo di dato di "phone_number" in UserDetails in CHAR
ALTER TABLE librarydb.userdetails MODIFY phone_number CHAR(10);

-- 9. Eliminare la colonna genre dalla tabella Books.
ALTER TABLE librarydb.books DROP COLUMN genre;

-- 10. Eliminare la colonna "birth_year" dalla tabella Authors
ALTER TABLE librarydb.authors DROP COLUMN birth_year;

-- 11. Eliminare la tabella Authors.
ALTER TABLE librarydb.books DROP CONSTRAINT books_authors_fk;
ALTER TABLE librarydb.books DROP COLUMN author_id;
DROP TABLE librarydb.authors;

-- 12. Eliminare il database LibraryDB.
DROP DATABASE librarydb;








