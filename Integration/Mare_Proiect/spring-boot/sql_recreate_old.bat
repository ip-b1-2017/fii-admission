del FiiConcurs.db
sqlite3 FiiConcurs.db < gen_db_old\sql_drop_concurs.sql
sqlite3 FiiConcurs.db < gen_db_old\sql_create_concurs.sql
sqlite3 FiiConcurs.db < gen_db_old\sql_populate_studenti_concurs.sql