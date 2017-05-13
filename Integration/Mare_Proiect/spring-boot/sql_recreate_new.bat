sqlite3 FiiAdmission.db < gen_db_new\drop.sql
del FiiAdmission.db
sqlite3 FiiAdmission.db < gen_db_new\create.sql
sqlite3 FiiAdmission.db < gen_db_new\CANDIDAT.sql
sqlite3 FiiAdmission.db < gen_db_new\EXAMEN.sql
sqlite3 FiiAdmission.db < gen_db_new\NOTE.sql
sqlite3 FiiAdmission.db < gen_db_new\PROFESORI.sql
sqlite3 FiiAdmission.db < gen_db_new\USER.sql
sqlite3 FiiAdmission.db < gen_db_new\MEDIE.sql
sqlite3 FiiAdmission.db < gen_db_new\SALI.sql
sqlite3 FiiAdmission.db < gen_db_new\SALI_EXAMEN.sql
sqlite3 FiiAdmission.db < gen_db_new\FORM.sql
sqlite3 FiiAdmission.db < gen_db_new\STUDENTI.SQL