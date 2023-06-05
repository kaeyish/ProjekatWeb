package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Citalac;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.entity.StavkaPolice;
import jakarta.persistence.Column;

import java.util.HashSet;
import java.util.Set;

public class PolicaDto {

    private Long id;

    private String naziv;

    private boolean primarna;

    private Korisnik korisnik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isPrimarna() {
        return primarna;
    }

    public void setPrimarna(boolean primarna) {
        this.primarna = primarna;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Set<StavkaPolice> getStavkePolice() {
        return stavkePolice;
    }

    public void setStavkePolice(Set<StavkaPolice> stavkePolice) {
        this.stavkePolice = stavkePolice;
    }

    private Set<StavkaPolice> stavkePolice = new HashSet<>();

    public PolicaDto() {
    }

    public PolicaDto(Long id, String naziv, boolean primarna, Korisnik korisnik, Set<StavkaPolice> stavkePolice) {
        this.id = id;
        this.naziv = naziv;
        this.primarna = primarna;
        this.korisnik = korisnik;
        this.stavkePolice = stavkePolice;
    }

    public PolicaDto(Polica polica) {
        this.id = polica.getId();
        this.naziv = polica.getNaziv();
        this.primarna = polica.isPrimarna();
        this.korisnik = polica.getKorisnik();
        this.stavkePolice = polica.getStavkePolice();
    }
}
