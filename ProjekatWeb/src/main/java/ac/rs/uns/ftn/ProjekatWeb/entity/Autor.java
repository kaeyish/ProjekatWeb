package ac.rs.uns.ftn.ProjekatWeb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Autor extends Korisnik {
    @Column
    private boolean aktivnost;

    //spisak knjiga
    //@JsonManagedReference
    @OneToMany (mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set <Knjiga> knjige = new HashSet<>();

    public Autor() {
    }

    public Autor(boolean aktivnost, Set<Knjiga> knjige) {
        this.aktivnost = aktivnost;
        this.knjige = knjige;
    }

    public Autor(String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, Uloga uloga, boolean aktivnost) {
        super( ime, prezime, korisnickoIme, email, lozinka, datumRodjenja, profilnaSlika, opis, uloga);
        this.aktivnost = aktivnost;
    }

    public Autor(String email, String korisnicko_ime, String lozinka) {
        super("","",korisnicko_ime,email,lozinka,Date.from(Instant.now()),"slika.com", "SVAKA CAST ZA AUTORA", Uloga.AUTOR);
        this.aktivnost = true;
    }

    public boolean isAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(boolean aktivnost) {
        this.aktivnost = aktivnost;
    }

    public Set<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(Set<Knjiga> knjige) {
        this.knjige = knjige;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "aktivnost=" + aktivnost +
                ", knjige=" + knjige +
                '}';
    }
}
