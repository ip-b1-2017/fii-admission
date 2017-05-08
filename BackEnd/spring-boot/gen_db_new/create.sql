CREATE TABLE CANDIDAT (
  CNP       varchar(13) NOT NULL, 
  TELEFON   varchar(16) NOT NULL, 
  NUME      varchar(255) NOT NULL, 
  PRENUME   varchar(255) NOT NULL, 
  USEREMAIL varchar(255) NOT NULL, 
  PRIMARY KEY (CNP), 
  FOREIGN KEY(USEREMAIL) REFERENCES USER(EMAIL)
  );

CREATE TABLE EXAMEN (
  ID         varchar(10) NOT NULL, 
  NR_PROBA   integer(10) NOT NULL, 
  START_DATE timestamp NOT NULL, 
  END_DATE   timestamp NOT NULL, 
  TIP        varchar(255) NOT NULL, 
  PRIMARY KEY (ID)
  );

CREATE TABLE FORM (
  FORMULAR        text NOT NULL, 
  STATUS      integer(4) NOT NULL, 
  CANDIDATCNP varchar(13) NOT NULL, 
  FOREIGN KEY(CANDIDATCNP) REFERENCES CANDIDAT(CNP)
  );

CREATE TABLE MEDIE (
  VALOARE     numeric(2, 0) NOT NULL, 
  CANDIDATCNP varchar(13) NOT NULL, 
  FOREIGN KEY(CANDIDATCNP) REFERENCES CANDIDAT(CNP)
  );

CREATE TABLE NOTE (
  VALOARE     numeric(2, 0) NOT NULL, 
  CANDIDATCNP varchar(13) NOT NULL, 
  EXAMENID    varchar(10) NOT NULL, 
  FOREIGN KEY(EXAMENID) REFERENCES EXAMEN(ID), 
  FOREIGN KEY(CANDIDATCNP) REFERENCES CANDIDAT(CNP)
  );

CREATE TABLE NOTIFICARI (
  TEXT      varchar(255) NOT NULL, 
  SEEN      integer(2) NOT NULL, 
  USEREMAIL varchar(255) NOT NULL, 
  FOREIGN KEY(USEREMAIL) REFERENCES USER(EMAIL)
  );

CREATE TABLE PROFESORI (
  NUME                varchar(255) NOT NULL, 
  PRENUME             varchar(255) NOT NULL, 
  PCNP                varchar(13) NOT NULL, 
  SALI_EXAMENSALIID   varchar(5) NOT NULL, 
  SALI_EXAMENEXAMENID varchar(10) NOT NULL, 
  PRIMARY KEY (PCNP), 
  FOREIGN KEY(SALI_EXAMENSALIID, SALI_EXAMENEXAMENID) REFERENCES SALI_EXAMEN(SALIID, EXAMENID)
  );

CREATE TABLE SALI (
  ID      varchar(5) NOT NULL, 
  LOCATIE varchar(255) NOT NULL, 
  LOCURI  integer(3) NOT NULL, 
  PRIMARY KEY (ID)
  );

CREATE TABLE SALI_EXAMEN (
  SALIID   varchar(5) NOT NULL, 
  EXAMENID varchar(10) NOT NULL, 
  PRIMARY KEY (SALIID, 
  EXAMENID), 
  FOREIGN KEY(EXAMENID) REFERENCES EXAMEN(ID), 
  FOREIGN KEY(SALIID) REFERENCES SALI(ID)
  );

CREATE TABLE SALI_EXAMEN_CANDIDAT (
  SALI_EXAMENSALIID   varchar(5) NOT NULL, 
  SALI_EXAMENEXAMENID varchar(10) NOT NULL, 
  CANDIDATCNP         varchar(13) NOT NULL, 
  PRIMARY KEY (SALI_EXAMENSALIID, 
  SALI_EXAMENEXAMENID, 
  CANDIDATCNP), 
  FOREIGN KEY(SALI_EXAMENSALIID, SALI_EXAMENEXAMENID) REFERENCES SALI_EXAMEN(SALIID, EXAMENID), 
  FOREIGN KEY(CANDIDATCNP) REFERENCES CANDIDAT(CNP)
  );

CREATE TABLE USER (
  ROL   varchar(255) NOT NULL, 
  EMAIL  varchar(255) NOT NULL, 
  PAROLA varchar(255) NOT NULL, 
  TOKEN  varchar(255) NOT NULL, 
  PRIMARY KEY (EMAIL)
  );

CREATE TABLE STUDENTI (
	cnp 				varchar(16) PRIMARY KEY,
	username			varchar(255) default 'prenume.nume',
	nume_nastere		varchar(255),
   	telefon				varchar(16),
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

CREATE UNIQUE INDEX CANDIDAT_CNP 
  ON CANDIDAT (CNP);
CREATE UNIQUE INDEX EXAMEN_ID 
  ON EXAMEN (ID);
CREATE UNIQUE INDEX PROFESORI_PCNP 
  ON PROFESORI (PCNP);
CREATE UNIQUE INDEX SALI_ID 
  ON SALI (ID);
CREATE UNIQUE INDEX USER_EMAIL 
  ON USER (EMAIL);

