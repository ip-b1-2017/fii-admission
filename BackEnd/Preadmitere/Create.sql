CREATE TABLE Examen (id INTEGER NOT NULL PRIMARY KEY, nr_proba integer(10) NOT NULL, start_date timestamp NOT NULL, end_date timestamp NOT NULL, tip varchar(255) NOT NULL UNIQUE);
/
CREATE TABLE Note (UserCNP integer(13) NOT NULL, Examenid integer(10) NOT NULL, valoare numeric(2, 0) NOT NULL, UserCNP2 integer(13) NOT NULL, PRIMARY KEY (UserCNP, Examenid), FOREIGN KEY(Examenid) REFERENCES Examen(id), FOREIGN KEY(UserCNP2) REFERENCES "User"(CNP));
/
CREATE TABLE Orar (sala_id varchar(5) NOT NULL, examen_id integer(10) NOT NULL, PRIMARY KEY (sala_id, examen_id), FOREIGN KEY(examen_id) REFERENCES Examen(id), FOREIGN KEY(sala_id) REFERENCES Sali(id));
/
CREATE TABLE Sali (id varchar(5) NOT NULL, locatie varchar(255) NOT NULL UNIQUE, locuri integer(3) NOT NULL, nr_prof integer(2) NOT NULL, PRIMARY KEY (id));
/
CREATE TABLE Studii (UserCNP integer(13) NOT NULL, institutia varchar(255) NOT NULL, tara varchar(70) NOT NULL, localitatea varchar(70) NOT NULL, judetul varchar(70) NOT NULL, PRIMARY KEY (UserCNP), FOREIGN KEY(UserCNP) REFERENCES "User"(CNP));
/
CREATE TABLE "User" (CNP INTEGER NOT NULL PRIMARY KEY, "nume la nastere" varchar(255) NOT NULL, telefon varchar(16) NOT NULL UNIQUE, prenume varchar(255) NOT NULL, role varchar(32) NOT NULL, adresa varchar(255) NOT NULL, nationalitate varchar(255) NOT NULL, adresa_documente varchar(255) NOT NULL, "nume actual" varchar(255), "prenume tata" varchar(255) NOT NULL, "prenume mama" varchar(255) NOT NULL, sexul varchar(2) NOT NULL, data_nastere timestamp NOT NULL, "tara nastere" varchar(70) NOT NULL, "judet nastere" varchar(70) NOT NULL, "localitate nastere" varchar(255) NOT NULL, cetatenie varchar(70) NOT NULL, "limba materna" varchar(70) NOT NULL, etnie varchar(70), "stare civila" varchar(70), "date CI" varchar(255) NOT NULL, "date pasaport" varchar(255) NOT NULL, "cazare studii" varchar(2) NOT NULL, "cazare admitere" varchar(2) NOT NULL, "stare sociala speciala" varchar(255), dizabilitati varchar(2), nr_chitanta integer(10), suma_taxa integer(10), NoteUserCNP integer(13) NOT NULL, NoteExamenid integer(10) NOT NULL);
CREATE TABLE user_orar (CNP integer(13) NOT NULL, sala_id varchar(5) NOT NULL, examen_id integer(10) NOT NULL, PRIMARY KEY (CNP, sala_id, examen_id), FOREIGN KEY(sala_id, examen_id) REFERENCES Orar(sala_id, examen_id), FOREIGN KEY(CNP) REFERENCES "User"(CNP));
/
CREATE UNIQUE INDEX Examen_id ON Examen (id);
CREATE UNIQUE INDEX Sali_id ON Sali (id);
CREATE UNIQUE INDEX Studii_UserCNP ON Studii (UserCNP);
CREATE UNIQUE INDEX User_CNP ON "User" (CNP);

