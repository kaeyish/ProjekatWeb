package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Citalac;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.entity.Uloga;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class KorisnikDto {
    private Long id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String email;
    private String lozinka;
    private Date datumRodjenja;
    private String profilnaSlika;
    private String opis;
    private Uloga uloga;
    private Polica wantToRead;
    private Polica currentlyReading;
    private Polica read;
    private Set<Polica> ostalePolice = new HashSet<>();

    private String novaLozinka;

    public KorisnikDto() {
    }

    public KorisnikDto(Long id, String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, Uloga uloga, Polica wantToRead, Polica currentlyReading, Polica read, Set<Polica> ostalePolice) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.email = email;
        this.lozinka = lozinka;
        this.datumRodjenja = datumRodjenja;
        this.profilnaSlika = profilnaSlika;
        this.opis = opis;
        this.uloga = uloga;
        this.wantToRead = wantToRead;
        this.currentlyReading = currentlyReading;
        this.read = read;
        this.ostalePolice = ostalePolice;
    }

    public KorisnikDto (Korisnik  korisnik){
        this.id = korisnik.getId();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.korisnickoIme = korisnik.getKorisnickoIme();
        this.email = korisnik.getEmail();
        this.lozinka = korisnik.getLozinka();
        this.datumRodjenja = korisnik.getDatumRodjenja();
        this.profilnaSlika = korisnik.getProfilnaSlika();
        this.opis = korisnik.getOpis();
        this.uloga = korisnik.getUloga();
        this.wantToRead = korisnik.getWantToRead();
        this.currentlyReading = korisnik.getCurrentlyReading();
        this.read = korisnik.getRead();
        this.ostalePolice = korisnik.getOstalePolice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getProfilnaSlika() {
        return profilnaSlika;
    }

    public void setProfilnaSlika(String profilnaSlika) {
        this.profilnaSlika = profilnaSlika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Uloga getUloga() {return uloga;}

    public void setUloga(Uloga uloga) {this.uloga = uloga;}

    public Polica getWantToRead() {
        return wantToRead;
    }

    public void setWantToRead(Polica wantToRead) {
        this.wantToRead = wantToRead;
    }

    public Polica getCurrentlyReading() {
        return currentlyReading;
    }

    public void setCurrentlyReading(Polica currentlyReading) {
        this.currentlyReading = currentlyReading;
    }

    public Polica getRead() {
        return read;
    }

    public void setRead(Polica read) {
        this.read = read;
    }

    public Set<Polica> getOstalePolice() {
        return ostalePolice;
    }

    public void setOstalePolice(Set<Polica> ostalePolice) {
        this.ostalePolice = ostalePolice;
    }

    public String getNovaLozinka() {
        return novaLozinka;
    }

    public void setNovaLozinka(String novaLozinka) {
        this.novaLozinka = novaLozinka;
    }
}
