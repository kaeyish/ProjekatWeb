package ac.rs.uns.ftn.ProjekatWeb.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Citalac extends Korisnik {
    public Citalac() {
    }

    public Citalac(String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, Uloga uloga) {
        super(ime, prezime, korisnickoIme, email, lozinka, datumRodjenja, profilnaSlika, opis, uloga);
    }
}