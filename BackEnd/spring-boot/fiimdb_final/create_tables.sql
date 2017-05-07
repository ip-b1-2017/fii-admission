ALTER TABLE MOVIE_DIRECTOR DROP CONSTRAINT director_md_fk;
DROP TABLE DIRECTOR;
CREATE TABLE DIRECTOR(
    id NUMBER(10, 0) PRIMARY KEY,
    first_name VARCHAR2(255),
    last_name VARCHAR2(255),
    birthday_date DATE
);

 --many to many table for director and movie
 
DROP TABLE MOVIE_DIRECTOR;
CREATE TABLE MOVIE_DIRECTOR(
    movie_id NUMBER(10, 0),
    director_id NUMBER(10, 0),
    CONSTRAINT movie_md_fk FOREIGN KEY (movie_id) REFERENCES MOVIE(ID) ON DELETE CASCADE,
    CONSTRAINT director_md_fk FOREIGN KEY (director_id) REFERENCES DIRECTOR(ID) ON DELETE CASCADE
);

ALTER TABLE MOVIE_ACTOR DROP CONSTRAINT actor_ma_fk;
DROP TABLE ACTOR;
CREATE TABLE ACTOR(
    id NUMBER(10, 0) PRIMARY KEY,
    first_name VARCHAR2(255),
    last_name VARCHAR2(255),
    birthday_date DATE
);

 --many to many table for actor and movie
DROP TABLE MOVIE_ACTOR;
CREATE TABLE MOVIE_ACTOR(
    movie_id NUMBER(10, 0),
    actor_id NUMBER(10, 0),
    CONSTRAINT movie_ma_fk FOREIGN KEY (movie_id) REFERENCES MOVIE(ID) ON DELETE CASCADE,
    CONSTRAINT actor_ma_fk FOREIGN KEY (actor_id) REFERENCES ACTOR(ID) ON DELETE CASCADE
);

ALTER TABLE USERS_ROLES DROP CONSTRAINT user_fk;
DROP TABLE USERS;
CREATE TABLE USERS(
    username VARCHAR2(128) PRIMARY KEY,
    password VARCHAR2(255),
    first_name VARCHAR2(255),
    last_name VARCHAR2(255),
    birthday_date DATE,
    rolename VARCHAR2(32)
);

DROP TABLE COMMENTS;
CREATE TABLE COMMENTS(
    movie_id NUMBER,
    username VARCHAR2(128),
    user_comment VARCHAR2(1024),
    created_at DATE,
    CONSTRAINT movie_comm_fk FOREIGN KEY (movie_id) REFERENCES MOVIE(ID) ON DELETE CASCADE,
    CONSTRAINT username_comm_fk FOREIGN KEY (username) REFERENCES USERS(username) ON DELETE CASCADE
);


CREATE SEQUENCE director_id_seq
    START WITH 1;
    
CREATE SEQUENCE actor_id_seq
    START WITH 1;