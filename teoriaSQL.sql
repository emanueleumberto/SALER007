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