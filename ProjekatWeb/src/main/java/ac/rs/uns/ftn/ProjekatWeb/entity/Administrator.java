package ac.rs.uns.ftn.ProjekatWeb.entity;

import jakarta.persistence.Entity;

import java.util.Date;
import java.util.Set;

@Entity
public class Administrator extends Korisnik{

    public Administrator() {
    }

    public Administrator( String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, Uloga uloga) {
        super(ime, prezime, korisnickoIme, email, lozinka, datumRodjenja, profilnaSlika, opis, uloga);
    }
}
