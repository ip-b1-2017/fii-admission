DROP TABLE GENRE;
CREATE TABLE GENRE
(
    ID NUMBER(10, 0) PRIMARY KEY,
    TYPE VARCHAR2(128) NOT NULL UNIQUE
);

DROP TABLE MOVIE_GENRE;
CREATE TABLE MOVIE_GENRE
(
    GENRE_ID NUMBER(10, 0),
    MOVIE_ID NUMBER,
    CONSTRAINT movie_fk FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(ID) ON DELETE CASCADE,
    CONSTRAINT genre_fk FOREIGN KEY (GENRE_ID) REFERENCES GENRE(ID) ON DELETE CASCADE,
    CONSTRAINT moviegenre_pk PRIMARY KEY (GENRE_ID, MOVIE_ID) 
);

INSERT INTO MOVIE_GENRE VALUES (1, 3);
INSERT INTO MOVIE_GENRE VALUES (2, 50);
INSERT INTO MOVIE_GENRE VALUES (3, 50);
INSERT INTO MOVIE_GENRE VALUES (4, 50);
INSERT INTO MOVIE_GENRE VALUES (3, 51);

COMMIT;