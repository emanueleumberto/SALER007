-- Commenti a singola riga
/*
	Commenti 
    multi riga
*/

/*
	SQL ha diverse categorie di statement
    DDL -> Data Definition Language
		- Definisce tutte le istruzioni SQL 
		  per la creazione e gestione di un DB
	DML -> Data Manipolation Language
		- Definisce tutte le istruzioni SQL 
          per la creazione e gestione delle
          tabelle contenute in un DB
	DQL -> Data Query Language
		- Definisce tutte le istruzioni SQL 
          per la lettura di dati in un DB
	DCL -> Data Control Language
		- Definisce tutte le istruzioni SQL
          per la gestione e i permessi di un DB
*/

-- TEORIA

-- DDL -> Data Definition Language

-- DB
-- CREATE | USE | ALTER | DROP | SHOW
-- CREATE DATABASE [IF NOT EXISTS] db_name;
-- SHOW DATABSES;
-- USE db_name;
-- DROP DATABASE [IF EXISTS] db_name;
-- RENAME DATABASE old_db_name TO new_db_name; (Deprecata)
-- ALTER DATABASE existing_db_name MODIFY NAME = new_db_name; (Deprecata)

-- TABLE
-- CREATE | ALTER | DROP 
/* CREATE TABLE [IF NOT EXISTS] db_name.table_name (
	column_name datatype column_constraints,
    column_name datatype column_constraints,
    ....
    column_name datatype column_constraints
    [constraint_name] table_constraints
) */
-- DROP TABLE [IF EXISTS] db_name.table_name [CASCADE | RESTRICT];
-- ALTER TABLE db_name.table_name ADD COLUMN column_name datatype column_constraints;
-- ALTER TABLE db_name.table_name DROP column_name [CASCADE | RESTRICT];
-- ALTER TABLE db_name.table_name RENAME COLUMN old_column_name TO new_column_name;
-- ALTER TABLE db_name.table_name MODIFY column_name datatype
-- ALTER TABLE db_name.table_name ADD CONSTRAINT [constraint_name] table_constraints
-- ALTER TABLE db_name.table_name DROP CONSTRAINT constraint_name

-- RELAZIONI -> OneToOne - OneToMany | ManyToOne - ManyToMany

-- DML -> Data Manipolation Language 
-- INSERT | UPDATE | DELETE

-- INSERT INTO db_name.table_name (column_name1, column_name2, column_name3, ..., column_nameN)
--							VALUES (value1, value2, value3, ..., valueN);

-- UPDATE db_name.table_name 
--	SET column_name1 = newValue1, column_name2 = newValue2, ...., column_nameN = newValueN 
--	WHERE column_name = value;

-- DELETE FROM db_name.table_name WHERE column_name = value;

-- DQL -> Data Query Language

-- SELECT 	-> Un elenco di campi o tutto (*) da restirue in un resultset di dati
-- FROM 	-> Indica la sorgente di dati da cui leggere (la/le tabelle)
-- WHERE	-> Search Condition, applica un filtro sulle righe della tabella indicata nel FROM
-- GROUP BY	-> Aggrega dei dati rispetto ad un a combinazione univoca data dalla group by list
-- HAVING	-> Search Condition, applica un filtro sulle righe della tabella filtrata e aggragata dal GROUP BY
-- ORDER BY	-> Consente di definire un ordinamento ben preciso
-- LIMIT	-> Consente di selezionare un numero definito di record

/*
	SELECT [DISTINCT]  column_name1, column_name2, column_name3, ..., column_nameN | * | aggregate_function(expression)
		FROM db_name.table_name
        [WHERE search condition]
        [GROUP BY]
        [HAVING search condition]
        [ORDER BY]
        [LIMIT]
*/

/*
	Operatori di confronto della Search Condition
	= (uguale)
    > (maggiore di)
    < (minore di)
    >= (maggiore uguale)
    <= (minore uguale)
    <> | != (diverso da)
    !< (non minore di)
    !> (non maggiore di)
*/

/*
	Operatori logici della Search Condition
    AND (restituisce true solo le entrambe le condizioni boolene restituiscono true)
    OR (restituisce true se almento una delle condizioni boolene restituisce true)
*/

/*
	LIKE (contiene... | caratteri Jolly -> %_)
    BETWEEN (restituisce tutti i valori compresi tra >= AND <= del range specificato)
    IN | NOT IN (Un elenco di dati in cui individuare una corrispondenza)
*/

/*
	Functions SQL
    
    String Function
    https://dev.mysql.com/doc/refman/8.4/en/string-functions.html
    CONCAT(column_name1, ' ', column_name2) -> funzione che permette di concatenare due o più colonne
    UPPER('String' | column_name) -> funzione che permette di trasformare un valore in maiuscolo 
    LOWER('String' | column_name) -> funzione che permette di trasformare un valore in minuscolo 
    LENGTH('String' | column_name) -> funzione che restituisce la lunghezza di una stringa o del valore di un campo
    TRIM('String' | column_name) -> funzione che restituisce un valore senza spazi vuoti prima o sopo la stringa
    
    Numeric Function
    https://dev.mysql.com/doc/refman/8.4/en/numeric-functions.html
    COUNT(* | DISTINCT column_name) -> funzione che restituisce il numero di record di una query
    FORMAT(number | column_name, 2) -> funzione che restituisce un numero decimale formattato
    TRUNCATE(number | column_name, 2) -> funzione che restituisce un numero decimale troncato
    ABS(number | column_name) -> funzione che restituisce un valore assoluto, senza segno (-)
    AVG(column_name) ->  funzione che restituisce la media dei valori di una colonna
    CEIL(column_name) -> funzione che restituisce un valore arrotondato per eccesso
    FLOOR(column_name) -> funzione che restituisce un valore arrotondato per difetto
    ROUND(column_name) -> funzione che restituisce un valore arrotondato la numero intero più vicino 
    RAND() -> funzione che restituisce un valore casuale da 0 a 1
    MAX(column_name) -> funzione che restituisce il valore massimo 
    MIN(column_name) -> funzione che restituisce il valore minimo
    SUM(column_name) -> funzione che restituisce la somma dei valori di una colonna
    
    Date Function
    https://dev.mysql.com/doc/refman/8.4/en/date-and-time-functions.html
    ADDDATE(date, n) -> funzione che aggiunge n ad una data
    ADDTIME(datetime, n) -> funzione che aggiunge n ad un valore orario
    CURRENT_DATE() -> funzione che restituisce una data in formato 'YYYY-MM-DD' (String)
    CURRENT_TIME() -> funzione che restituisce un orario in formato 'HH-MM-SS' (String)
    CURRENT_TIMESTAMP() -> funzione che restituisce data e ora del momento
    DATEDIFF(date1, date2) -> funzione che calcola la differenza di giorni tra due date
    DAY(date) ->  funzione che restituisce il giorno da una data completa
    MONTH(date) ->  funzione che restituisce il mese da una data completa
    YEAR(date) ->  funzione che restituisce l'anno da una data completa
    HOUR(datetime) ->  funzione che restituisce l'ora da una data completa
    MINUTE(datetime) ->  funzione che restituisce i minuti da una data completa
    SECOND(datetime) ->  funzione che restituisce i secondi da una data completa
    
    Advanced Function
    ISNULL(column_name) -> funzione che restituisce 1 o 0 in base al valore NULL contenuto in una colonna
    LAST_INSERT_ID() -> funzione che restituisce l'ultimo valore intero del campo ID della colonna PK
*/

/*
	SELECT [DISTINCT]  column_name1, column_name2, column_name3, ..., column_nameN | * | aggregate_function(expression)
		FROM db_name.table_name1 as a
        INNER JOIN db_name.table_name2 as b
        ON a.column_name = b.column_name
	
    SELECT [DISTINCT]  column_name1, column_name2, column_name3, ..., column_nameN | * | aggregate_function(expression)
		FROM db_name.table_name1 as a
        LEFT JOIN db_name.table_name2 as b
        ON a.column_name = b.column_name
	
    SELECT [DISTINCT]  column_name1, column_name2, column_name3, ..., column_nameN | * | aggregate_function(expression)
		FROM db_name.table_name1 as a
        RIGHT JOIN db_name.table_name2 as b
        ON a.column_name = b.column_name
*/


-- PRATICA
-- SHOW DATABASES;
-- DROP DATABASE IF EXISTS saler007;
CREATE DATABASE IF NOT EXISTS saler007;
-- ALTER DATABASE saler007 CHARACTER SET = utf8;
USE saler007;


CREATE TABLE IF NOT EXISTS saler007.users (
	user_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    lastname VARCHAR(25) NOT NULL,
    age INT UNSIGNED NULL DEFAULT 18,
    city CHAR(10) NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    CONSTRAINT user_pk PRIMARY KEY(user_id)
);
-- DROP TABLE IF EXISTS saler007.users;
ALTER TABLE saler007.users ADD COLUMN fiscal_code CHAR(16) NOT NULL UNIQUE;
ALTER TABLE saler007.users RENAME COLUMN name TO firstname;
ALTER TABLE saler007.users MODIFY city VARCHAR(25);
ALTER TABLE saler007.users DROP COLUMN email;

-- Relazione OneToOne
CREATE TABLE IF NOT EXISTS saler007.signin (
	signin_id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    user_id INT NOT NULL UNIQUE,
    CONSTRAINT signin_pk PRIMARY KEY(signin_id),
    -- CONSTRAINT signin_users_fk FOREIGN KEY(signin_id) REFERENCES users(user_id)
    CONSTRAINT signin_users_fk 
			FOREIGN KEY(user_id) 
            REFERENCES users(user_id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

-- Relazione OneToMany o ManyToOne
CREATE TABLE IF NOT EXISTS saler007.cars (
	car_id INT NOT NULL AUTO_INCREMENT,
    car_name VARCHAR(25) NOT NULL,
    car_license_plate CHAR(7) NOT NULL UNIQUE,
    user_id INT NOT NULL,
    CONSTRAINT car_pk PRIMARY KEY(car_id),
    CONSTRAINT cars_users_fk
			FOREIGN KEY(user_id)
            REFERENCES users(user_id)
            ON UPDATE CASCADE
            ON DELETE CASCADE
);

-- Relazione ManyToMany
CREATE TABLE IF NOT EXISTS saler007.courses (
	course_id INT NOT NULL AUTO_INCREMENT,
    course_name VARCHAR(25) NOT NULL,
    course_code INT NOT NULL,
    course_hours INT NULL DEFAULT 250,
    CONSTRAINT course_pk PRIMARY KEY(course_id)
);

CREATE TABLE IF NOT EXISTS saler007.users_courses (
	users_course_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    CONSTRAINT user_course_pk PRIMARY KEY(users_course_id)
    /*CONSTRAINT users_coursesfk1 
		FOREIGN KEY(user_id) 
        REFERENCES users(user_id)
        ON UPDATE CASCADE
		ON DELETE CASCADE,
	CONSTRAINT users_coursesfk2
		FOREIGN KEY(course_id) 
        REFERENCES courses(course_id)
        ON UPDATE CASCADE
		ON DELETE CASCADE*/
);

-- ALTER TABLE saler007.users_courses DROP CONSTRAINT users_coursesfk1;
-- ALTER TABLE saler007.users_courses DROP CONSTRAINT users_coursesfk2;

ALTER TABLE saler007.users_courses 
	ADD COLUMN iscr_date TIMESTAMP 
    DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP;
    
ALTER TABLE saler007.users_courses 
	ADD CONSTRAINT users_coursesfk1 
    FOREIGN KEY(user_id) 
    REFERENCES users(user_id)
    ON UPDATE CASCADE
	ON DELETE CASCADE;
    
ALTER TABLE saler007.users_courses 
	ADD CONSTRAINT users_coursesfk2 
    FOREIGN KEY(course_id) 
	REFERENCES courses(course_id)
	ON UPDATE CASCADE
	ON DELETE CASCADE;
    
    
CREATE TABLE IF NOT EXISTS saler007.taba(
	id_tab_a INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    id_tab_b INT NOT NULL
    -- FOREIGN KEY(id_tab_b) REFERENCES saler007.tabb(id_tab_b)
);

CREATE TABLE IF NOT EXISTS saler007.tabb(
	id_tab_b INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    id_tab_a INT NOT NULL
    -- FOREIGN KEY(id_tab_a) REFERENCES saler007.taba(id_tab_a)
);

ALTER TABLE saler007.taba ADD CONSTRAINT 
	FOREIGN KEY(id_tab_b) 
    REFERENCES saler007.tabb(id_tab_b)
    ON UPDATE CASCADE
	ON DELETE CASCADE;
    
ALTER TABLE saler007.tabb ADD CONSTRAINT 
	FOREIGN KEY(id_tab_a) 
    REFERENCES saler007.taba(id_tab_a)
    ON UPDATE CASCADE
	ON DELETE CASCADE;
    
-- DML
-- INSERT | UPDATE | DELETE

-- users -> user_id(PK) - firstname(NotNull) - lastname(NotNull) - age(Uns,Null,default18) - city(Null) - fiscal_code (CHAR(16) NOT NULL UNIQUE)
INSERT INTO saler007.users (firstname, lastname, age, city, fiscal_code) VALUES ("Mario", "Rossi", 40, "Roma", "ABCDEF12G34H567I"); -- Tutto ok
INSERT INTO saler007.users (firstname, lastname, city, fiscal_code) VALUES ("Giuseppe", "Verdi", "Milano", "ABCDEF12G34H567L"); -- age -> default 18
INSERT INTO saler007.users (firstname, lastname, age, fiscal_code) VALUES ("Francesca", "Neri", 22, "ABCDEF12G34H567M"); -- city -> null
-- INSERT INTO saler007.users (firstname, city, age, fiscal_code) VALUES ("Antonio", "Napoli", 31, "ABCDEF12G34H567N"); -- lastname -> not null ERRORE
-- INSERT INTO saler007.users (firstname, lastname, city, age, fiscal_code) VALUES ("Antonio", "Bianchi", "Napoli", 31, "ABCDEF12G34H567L"); -- fiscal_code -> unique ERRORE
INSERT INTO saler007.users (firstname, lastname, fiscal_code) VALUES ("Antonio", "Bianchi", "ABCDEF12G34H567N"); -- campi not null

-- signin -> signin_id(PK) - email(NotNull, UNIQUE) - password(NotNull) - user_id(NotNull, UNIQUE, FK)
INSERT INTO saler007.signin (email, password, user_id) 
			VALUES	("m.rossi@example.com", "Pa$$w0rd!", 1),
					("g.verdi@example.com", "Pa$$w0rd!", 2),
                    -- ("f.neri@example.com", "Pa$$w0rd!", 1), -> Errore user_id duplicato
                    ("a.bianchi@example.com", "Pa$$w0rd!", 4);

-- cars -> car_id(PK) - car_name(NotNull) - car_license_plate(NotNull) - user_id(NotNull, FK)
INSERT INTO saler007.cars (car_name, car_license_plate, user_id)
			VALUES 	("Fiat Panda", "AB123CD", 1),
					("Ford Fiesta", "DF456GH", 3),
                    ("Renault Clio", "IL789MN", 1),
                    ("Mercedes ClasseA", "OP147QR", 4);
    
-- courses -> course_id(PK) - course_name(NotNull) - course_code(NotNull) - course_hours(Null,default250)
INSERT INTO saler007.courses (course_name, course_code, course_hours)
			VALUES	("Java", 1, 100),
					("SQL", 2, 50),
                    ("Spring", 3, 80);
INSERT INTO saler007.courses (course_name, course_code) VALUES	("BackEnd", 4);

-- users_courses -> users_course_id(PK) - user_id(NotNull, FK) - course_id(NotNull, FK) - iscr_date(Timestamp Default CURRENT_TIMESTAMP)
INSERT INTO saler007.users_courses (user_id, course_id) 
			VALUES	(1, 2), (1, 4), (2, 4), (3, 2), (3, 1);

UPDATE saler007.courses SET course_name = "SpringBoot", course_hours = 75 WHERE course_id = 3;

-- DELETE FROM saler007.users WHERE user_id = 1;

-- DQL

SELECT * FROM saler007.users;
SELECT * FROM saler007.signin;
SELECT * FROM saler007.cars;
SELECT * FROM saler007.courses;
SELECT * FROM saler007.users_courses;


SELECT firstname, lastname FROM saler007.users;
SELECT firstname, lastname FROM saler007.users WHERE city = 'Milano';
SELECT * FROM saler007.users WHERE age < 20;
SELECT * FROM saler007.users WHERE lastname != 'Verdi';
SELECT * FROM saler007.users WHERE lastname != 'Verdi' AND age < 20;
SELECT * FROM saler007.users WHERE lastname LIKE '%er%';
SELECT * FROM saler007.users WHERE firstname LIKE '__a%';
SELECT * FROM saler007.users WHERE fiscal_code LIKE '%L';
SELECT * FROM saler007.users WHERE fiscal_code LIKE 'AB%L';
SELECT * FROM saler007.courses WHERE course_hours BETWEEN 50 AND 100;
SELECT * FROM saler007.courses WHERE course_name IN ('Javascript', 'Java', 'PHP', 'NodeJS', 'Python');
SELECT * FROM saler007.courses WHERE course_name NOT IN ('Javascript', 'Java', 'PHP', 'NodeJS', 'Python') AND course_hours > 100;
SELECT UPPER(course_name) FROM saler007.courses;
SELECT LOWER(course_name) FROM saler007.courses;
SELECT LENGTH(course_name) FROM saler007.courses;
SELECT CONCAT(course_name, '(', course_hours, ')') FROM saler007.courses;
SELECT COUNT(*) FROM saler007.courses WHERE course_hours > 50;
SELECT course_name, MAX(course_hours) FROM saler007.courses;
SELECT SUM(course_hours) FROM saler007.courses;
SELECT LAST_INSERT_ID() FROM saler007.cars;


SELECT city, count(*) FROM saler007.users GROUP BY city;
SELECT city, count(*) FROM saler007.users WHERE age >= 18 GROUP BY city;
SELECT city, count(*) FROM saler007.users WHERE age >= 18 GROUP BY city HAVING count(*) >= 2;
SELECT city, count(*) FROM saler007.users WHERE age >= 18 GROUP BY city HAVING count(*) >= 2 ORDER BY city ASC LIMIT 3;
-- FROM -> WHERE -> GROUP BY -> HAVING -> ORDER BY -> LIMIT -> SELECT

SELECT * FROM saler007.users;
SELECT * FROM saler007.signin;

SELECT *
	FROM saler007.signin AS s 
    INNER JOIN saler007.users AS u 
    ON s.user_id = u.user_id;

SELECT u.firstname, u.lastname, u.age, u.city, s.email 
	FROM saler007.signin AS s 
    INNER JOIN saler007.users AS u 
    ON s.user_id = u.user_id;
    
SELECT u.firstname, u.lastname, u.age, u.city, s.email 
	FROM saler007.users AS u 
    LEFT JOIN saler007.signin AS s 
    ON s.user_id = u.user_id;

SELECT u.firstname, u.lastname, u.age, u.city, s.email 
	FROM saler007.users AS u 
    RIGHT JOIN saler007.signin AS s 
    ON s.user_id = u.user_id;

