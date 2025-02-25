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
-- ALTER TABLE librarydb.books DROP COLUMN genre;

-- 10. Eliminare la colonna "birth_year" dalla tabella Authors
-- ALTER TABLE librarydb.authors DROP COLUMN birth_year;

-- 11. Eliminare la tabella Authors.
-- ALTER TABLE librarydb.books DROP CONSTRAINT books_authors_fk;
-- ALTER TABLE librarydb.books DROP COLUMN author_id;
-- DROP TABLE librarydb.authors;

-- 12. Eliminare il database LibraryDB.
-- DROP DATABASE librarydb;

-- Esercizio DML 
-- Inserire dai 5 ai 10 valori corretti in ogni tabella del database librarydb testando le relazioni e i vincoli di ogni tabella
-- Utilizzare le istruzioni INSERT, UPDATE, DELETE

-- Inserire utenti nella tabella users
ALTER TABLE librarydb.users MODIFY COLUMN email VARCHAR(25);

INSERT INTO librarydb.users (name, email) 
		VALUES 	('Mario Rossi', 'mario.rossi@email.com'),
				('Laura Bianchi', 'laura.bianchi@email.com'),
				('Giovanni Verdi', 'giovanni.verdi@email.com'),
                ('Giuseppe Viola', 'giuseppe.viola@email.com'),
                ('Francesca Neri', 'francesca.neri@email.com');
-- Inserire dettagli utente nella tabella userdetails
INSERT INTO librarydb.userdetails (user_id, address, phone_number)
		VALUES	(1, 'Via Roma 10, Milano', '3456789012'),
				(2, 'Corso Italia 25, Torino', '3334567890'),
				(3, 'Piazza Duomo 5, Napoli', '3923456789'),
                (4, 'Via Marconi 81, Firenze', '3924566012'),
                (5, 'Piazza Roma 50, Torino', '3330126789');

-- Inserire autori nella tabella authors
INSERT INTO librarydb.authors (name, birth_year)
		VALUES	('Umberto Eco', 1932),
				('J.K. Rowling', 1965),
                ('George Orwell', 1903),
                ('Davide Bacchi', 1968),
                ('Anna Salvati', 1948);
                
-- Inserire libri nella tabella books
INSERT INTO librarydb.books (title, publication_year, isbn, genre, author_id )
		VALUES	('Il Nome della Rosa', 1980, '978-88-061', 'romanzo', 1),
				('Harry Potter e la Pietra Filosofale', 1997, '978-88-092', 'fantasy', 2),
                ('1984', 1949, '978-45-228', 'romanzo', 3),
                ('Animali Fantastici e Dove Trovarli', 2001, '978-88-090', 'fantasy', 2),
                ('La ricerca. Ori Miradha', 2014, '978-88-911', 'fantasy',  5),
                ('Le terrecotte della donazione Guandalini Kabaivanska', 2024, '883-36-469', 'storico', 4);
                
-- Inserire i prestiti nella tabella loans
INSERT INTO librarydb.loans (user_id, book_id, loan_date, return_date)
		VALUES	(2, 5, '2025-01-08', null),
				(4, 1, '2025-02-12', '2025-02-15'),
                (2, 3, '2025-01-08', '2025-01-10'),
                (1, 2, '2025-01-26', null),
                (3, 3, '2025-01-11', '2025-01-18'),
                (5, 4, '2025-02-20', null);
                
-- Aggiornare indirizzo di un utente
UPDATE librarydb.userdetails SET address = 'Via Garibaldi 50 Torino' WHERE user_id = 5;
-- Aggiornare le informazioni di un libro
UPDATE librarydb.books SET publication_year = 2000 WHERE book_id = 1;
-- Aggiornare le informazioni sulla tabella prestiti
UPDATE librarydb.loans SET return_date = '2025-02-25' WHERE loan_id = 4;

SELECT * FROM librarydb.users;
SELECT * FROM librarydb.userdetails;
SELECT * FROM librarydb.authors;
SELECT * FROM librarydb.books;
SELECT * FROM librarydb.loans;

-- Esercizio DQL 
-- Recuperare Dati con Query (SELECT)

-- 1. Visualizzare tutti gli utenti e i loro dettagli

-- 2. Mostrare tutti i libri e i rispettivi autori 

-- 3. Recuperare tutti i prestiti con nomi degli utenti e titoli dei libri

-- 4. Trovare tutti i libri non ancora restituiti

-- 5. Contare quanti libri ha scritto ogni autore

-- 6. Trovare gli utenti che hanno preso in prestito almeno 2 libri

-- 7. Trovare tutti i libri pubblicati dopo il 2000 

-- 8. Trovare gli utenti che vivono in una città specifica

-- 9. Recuperare tutti i prestiti effettuati in un determinato intervallo di date

-- 10. Recuperare i libri scritti da un autore specifico (es. "J.K. Rowling")

-- 11. Elenco dei libri ordinato per anno di pubblicazione (dal più recente al più vecchio)

-- 12. Elenco dei prestiti ordinato per data di prestito (dal più recente)

-- 13. Contare quanti libri ci sono nella libreria

-- 14. Contare quanti libri ha scritto ogni autore

-- 15. Trovare l'anno di pubblicazione più vecchio e più recente dei libri

-- 16. Trovare gli utenti che hanno preso in prestito più di un libro

-- EXTRA

-- 17. Trovare gli utenti che hanno preso in prestito il libro più recente

-- 18. Trovare gli autori che non hanno ancora pubblicato libri

-- 19. Recuperare i prestiti con il numero totale di prestiti per utente

