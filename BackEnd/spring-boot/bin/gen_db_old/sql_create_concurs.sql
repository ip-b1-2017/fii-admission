CREATE TABLE EXAMEN (
	id 				integer PRIMARY KEY,
	nr_proba 		integer(10),
	start_date 		timestamp,
	end_date 		timestamp,
	tip 			varchar(255) UNIQUE
	);

CREATE TABLE MEDIE (
	cnp_student		varchar(16),
	valoare 		real,
	
	PRIMARY KEY (cnp_student),
	FOREIGN KEY (cnp_student) REFERENCES STUDENTI(cnp)
	);

CREATE TABLE NOTE (
	cnp_student 	varchar(16),
	examen_id 		integer(10),
	valoare 		real,
	
	PRIMARY KEY (cnp_student, examen_id),
	FOREIGN KEY (examen_id) REFERENCES EXAMEN(id),
	FOREIGN KEY (cnp_student) REFERENCES STUDENTI(cnp)
	);
	

CREATE TABLE ORAR (
	sala_id 		varchar(5),
	examen_id 		integer(10),

	PRIMARY KEY (sala_id, examen_id),
	FOREIGN KEY (examen_id) REFERENCES EXAMEN(id),
	FOREIGN KEY (sala_id) REFERENCES SALI(id)
	);

CREATE TABLE SALI (
	id				varchar(5) PRIMARY KEY,
	locatie 		varchar(255) UNIQUE,
	locuri			integer(3),
	nr_prof			integer(2)
	);

CREATE TABLE STUDII (
	cnp_student		integer(13),
	institutia 		varchar(255),
	tara			varchar(70),
	localitatea 	varchar(70),
	judetul 		varchar(70),
	
	PRIMARY KEY (cnp_student),
	FOREIGN KEY (cnp_student) REFERENCES STUDENTI(cnp)
	);

CREATE TABLE STUDENTI (
	cnp 				varchar(16) PRIMARY KEY,
	username			varchar(255) default 'prenume.nume',
	nume_nastere		varchar(255),
   	telefon				varchar(16) UNIQUE,
	prenume 			varchar(255),
	adresa 				varchar(255),
	nationalitate 		varchar(255),
	adresa_documente 	varchar(255),
	nume_actual 		varchar(255),
	prenume_tata 		varchar(255),
	prenume_mama		varchar(255),
	sexul 				varchar(2),
	data_nastere		varchar(64),
	tara_nastere 		varchar(70),
	judet_nastere 		varchar(70),
	localitate_nastere 	varchar(255),
	cetatenie 			varchar(70),
	limba_materna	 	varchar(70),
	etnie 				varchar(70),
	stare_civila 		varchar(70),
	date_ci 			varchar(255),
	date_pasaport	 	varchar(255),
	cazare_studii 		varchar(2),
	cazare_admitere 	varchar(2),
	stare_sociala		varchar(255),
	dizabilitati 		varchar(2),
	login_token			varchar(255) default '31415926535897932384626433832795028841971'
	);

CREATE TABLE STUDENTI_ORAR (
	cnp 			varchar(16),
	sala_id 		varchar(5),
	examen_id 		integer(10),
	
	PRIMARY KEY (cnp, sala_id, examen_id),
	FOREIGN KEY	(sala_id, examen_id) REFERENCES ORAR(sala_id, examen_id),
	FOREIGN KEY	(cnp) REFERENCES STUDENTI(cnp)
	);

CREATE UNIQUE INDEX idx_examen_id ON EXAMEN (id);
CREATE UNIQUE INDEX idx_sali_id ON SALI (id);
CREATE UNIQUE INDEX idx_studii_cnp_student ON STUDII (cnp_student);
CREATE UNIQUE INDEX idx_student_cnp ON STUDENTI (cnp);

