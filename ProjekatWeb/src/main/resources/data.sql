-- noinspection SqlResolveForFile

INSERT INTO KORISNIK (username) VALUES ('kaeyish');
INSERT INTO KNJIGA (naziv) VALUES ('MIST UNLIMITED');

INSERT INTO POLICA (naziv, primarna) VALUES ('TBR', true);
INSERT INTO RECENZIJA (ocena, tekst, datum, korisnik_id) VALUES ( 3, 'ITS MIST MAN', '2021-11-20', 1);


INSERT INTO STAVKA_POLICE (knjiga_id, recenzija_id) VALUES (1,1);

