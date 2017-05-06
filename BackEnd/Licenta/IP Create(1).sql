CREATE TABLE Detalii_Alte_Studii (
  NUME_INSTITUTIE  varchar(255) NOT NULL, 
  TARA             varchar(255) NOT NULL, 
  LOCALITATE       varchar(255) NOT NULL, 
  JUDET            varchar(255) NOT NULL, 
  PROFIL           varchar(255) NOT NULL, 
  DURATA_STUDII    varchar(20), 
  ANUL_ABSOLVIRII  integer(10) NOT NULL, 
  FORMA_INVATAMANT integer(255) NOT NULL, 
  NUMAR_MATRICOL   integer(20) NOT NULL, 
  DOMENIU_LICENTA  varchar(255), 
  ANI_BUGET        integer(10), 
  ANI_BURSA        integer(10), 
  TITLU_OBTINUT    varchar(255), 
  NUMAR_SUPLIMENT  integer(100), 
  ACT_NUMAR        integer(10) NOT NULL, 
  ACT_SERIE        integer(10) NOT NULL, 
  ACT_DATA_EMITERE date NOT NULL, 
  ACT_EMIS         varchar(255) NOT NULL, 
  NUME_ACT         varchar(255) NOT NULL, 
  SPECIALIZARE     varchar(255), 
  STUDENT_CNP      integer(13) NOT NULL, 
  NUME_ACT_COPIE   integer(10), 
  PRIMARY KEY (STUDENT_CNP), 
  FOREIGN KEY(STUDENT_CNP) REFERENCES STUDENT(CNP));
CREATE TABLE EXAMEN (
  ID         INTEGER NOT NULL PRIMARY KEY, 
  NR_PROBA   integer(10) NOT NULL, 
  START_DATE date NOT NULL, 
  END_DATE   date NOT NULL, 
  TIP        varchar(255) NOT NULL UNIQUE);
CREATE TABLE MEDIE (
  CNP     integer(13) NOT NULL, 
  VALOARE numeric(2, 0) NOT NULL, 
  PRIMARY KEY (CNP), 
  FOREIGN KEY(CNP) REFERENCES STUDENT(CNP));
CREATE TABLE NOTE (
  STUDENT_CNP integer(13) NOT NULL, 
  EXAMEN_ID   integer(10) NOT NULL, 
  VALOARE     numeric(2, 0) NOT NULL, 
  PRIMARY KEY (STUDENT_CNP, 
  EXAMEN_ID), 
  FOREIGN KEY(EXAMEN_ID) REFERENCES EXAMEN(ID), 
  FOREIGN KEY(STUDENT_CNP) REFERENCES STUDENT(CNP));
CREATE TABLE ORAR (
  SALI_ID   varchar(5) NOT NULL, 
  EXAMEN_ID integer(10) NOT NULL, 
  PRIMARY KEY (SALI_ID, 
  EXAMEN_ID), 
  FOREIGN KEY(EXAMEN_ID) REFERENCES EXAMEN(ID), 
  FOREIGN KEY(SALI_ID) REFERENCES SALI(ID));
CREATE TABLE PREFERINTE (
  ECHIVALARE_OLIMPIADA varchar(3), 
  PREADMITERE          varchar(3), 
  RELUARE_EXAMEN_SCRIS varchar(3), 
  PREDARE_ROMANA       integer(2), 
  PREDARE_ENGLEZA      integer(2), 
  TAXA                 integer(20) NOT NULL, 
  "Column"             integer(10), 
  STUDENT_CNP          INTEGER NOT NULL PRIMARY KEY);
CREATE TABLE SALI (
  ID      varchar(5) NOT NULL, 
  LOCATIE varchar(255) NOT NULL UNIQUE, 
  LOCURI  integer(3) NOT NULL, 
  NR_PROF integer(2) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE STUDENT (
  NUME_NASTERE           varchar(255) NOT NULL, 
  NUME_ACTUAL            varchar(255) NOT NULL, 
  PRENUME                varchar(255) NOT NULL, 
  PRENUME_TATA           varchar(255) NOT NULL, 
  PRENUME_MAMA           varchar(255) NOT NULL, 
  CNP                    INTEGER NOT NULL PRIMARY KEY, 
  SEXUL                  varchar(2) NOT NULL, 
  DATA_NASTERE           date NOT NULL, 
  TARA_NASTERE           varchar(70) NOT NULL, 
  JUDET_NASTERE          varchar(70) NOT NULL, 
  LOCALITATE_NASTERE     varchar(255) NOT NULL, 
  CETATENIE              varchar(70) NOT NULL, 
  NATIONALITATE          varchar(255) NOT NULL, 
  ETNIE                  varchar(70), 
  LIMBA_MATERNA          varchar(70) NOT NULL, 
  STARE_CIVILA           varchar(20), 
  DATE_CI                varchar(255) NOT NULL, 
  DATE_PASAPORT          varchar(255) NOT NULL, 
  ADRESA                 varchar(255) NOT NULL, 
  CAZARE_STUDII          varchar(2), 
  CAZARE_ADMITERE        varchar(2), 
  STARE_SOCIALA_SPECIALA varchar(255), 
  DIZABILITATI           varchar(255), 
  TELEFON                varchar(16) NOT NULL UNIQUE, 
  MEDIE_BAC              integer(10) NOT NULL, 
  NOTA_BAC_MAX           integer(10) NOT NULL, 
  PREFERINTESTUDENT_CNP  integer(13) NOT NULL, 
  FOREIGN KEY(PREFERINTESTUDENT_CNP) REFERENCES PREFERINTE(STUDENT_CNP));
CREATE TABLE STUDENT_ORAR (
  STUDENT_CNP integer(13) NOT NULL, 
  SALA_ID     varchar(5) NOT NULL, 
  EXAMEN_ID   integer(10) NOT NULL, 
  PRIMARY KEY (STUDENT_CNP, 
  SALA_ID, 
  EXAMEN_ID), 
  FOREIGN KEY(SALA_ID, EXAMEN_ID) REFERENCES ORAR(SALI_ID, EXAMEN_ID), 
  FOREIGN KEY(STUDENT_CNP) REFERENCES STUDENT(CNP));
CREATE UNIQUE INDEX EXAMEN_ID 
  ON EXAMEN (ID);
CREATE UNIQUE INDEX SALI_ID 
  ON SALI (ID);
CREATE UNIQUE INDEX STUDENT_CNP 
  ON STUDENT (CNP);

