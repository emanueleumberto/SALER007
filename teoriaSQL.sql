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


-- DQL -> Data Query Language

-- PRATICA
-- SHOW DATABASES;
DROP DATABASE IF EXISTS saler007;
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

ALTER TABLE saler007.users_courses DROP CONSTRAINT users_coursesfk1;
ALTER TABLE saler007.users_courses DROP CONSTRAINT users_coursesfk2;

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
INSERT INTO saler007.users (firstname, city, age, fiscal_code) VALUES ("Antonio", "Napoli", 31, "ABCDEF12G34H567N"); -- lastname -> not null ERRORE
INSERT INTO saler007.users (firstname, lastname, city, age, fiscal_code) VALUES ("Antonio", "Bianchi", "Napoli", 31, "ABCDEF12G34H567L"); -- fiscal_code -> unique ERRORE
INSERT INTO saler007.users (firstname, lastname, fiscal_code) VALUES ("Antonio", "Bianchi", "ABCDEF12G34H567N"); -- campi not null

-- signin -> signin_id(PK) - email(NotNull, UNIQUE) - password(NotNull) - user_id(NotNull, UNIQUE, FK)
INSERT INTO saler007.signin (email, password, user_id) 
			VALUES	("m.rossi@example.com", "Pa$$w0rd!", 1),
					("g.verdi@example.com", "Pa$$w0rd!", 2),
                    -- ("f.neri@example.com", "Pa$$w0rd!", 1), -> Errore user_id duplicato
                    ("a.bianchi@example.com", "Pa$$w0rd!", 5);

-- cars -> car_id(PK) - car_name(NotNull) - car_license_plate(NotNull) - user_id(NotNull, FK)
INSERT INTO saler007.cars (car_name, car_license_plate, user_id)
			VALUES 	("Fiat Panda", "AB123CD", 1),
					("Ford Fiesta", "DF456GH", 3),
                    ("Renault Clio", "IL789MN", 1),
                    ("Mercedes ClasseA", "OP147QR", 5);
    
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

DELETE FROM saler007.users WHERE user_id = 1;

SELECT * FROM saler007.users;
SELECT * FROM saler007.signin;
SELECT * FROM saler007.cars;
SELECT * FROM saler007.courses;
SELECT * FROM saler007.users_courses;