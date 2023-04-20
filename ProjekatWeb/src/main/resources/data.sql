INSERT INTO ADMINISTRATOR (id, ime, prezime, korisnicko_ime, mail, lozinka, datum_rodjenja, profilna_slika, opis) VALUES (1, 'Andjela', 'Petkovic', 'brownotter', 'nekimejl@gmail.com', 'pass', '2002-02-26','slika.com','ovo je neki opis');

INSERT INTO CITALAC (id, ime, prezime, korisnicko_ime, mail, lozinka, datum_rodjenja, profilna_slika, opis) VALUES (2, 'Imenko', 'Prezimenko', 'korime', 'imenko@gmail.com', 'sifra', '2002-02-02','www.sajtzasliku.com','volim da citam');

INSERT INTO AUTOR (id, ime, prezime, korisnicko_ime, mail, lozinka, datum_rodjenja, profilna_slika, opis, aktivnost) VALUES (3, 'J.R.R', 'Tolkien', 'jrrtolkien', 'jrrtolkien@gmail.com', 'password', '1892-03-01','njegovaslika.com','pisac knjiga', true);

INSERT INTO KNJIGA (naslov, naslovna_fotografija, ISBN, datum_objavljivanja, broj_strana, opis, ocena) VALUES ('The Fellowship of the rings','www.slika,com',10101,'1954-01-01',400,'prva knjiga',9.0);

INSERT INTO ZANR(naziv)VALUES ('naucna fantastika');
INSERT INTO ZANR(naziv)VALUES ('triler');
INSERT INTO ZANR(naziv)VALUES ('romantika');

INSERT INTO ZANROVI_KNJIGA (zanr_id, knjiga_id) VALUES (1,1)