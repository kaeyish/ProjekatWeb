package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Autor;
import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.entity.Uloga;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AutorDto {
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
    private boolean aktivnost;
    private Set<Knjiga> knjige = new HashSet<>();

    private Set<Polica> ostalePolice = new HashSet<>();

    public AutorDto() {
    }

    public AutorDto(Long id, String ime, String prezime, String korisnickoIme, String mail, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, Uloga uloga,boolean aktivnost, Set<Knjiga> knjige, Polica wantToRead, Polica currentlyReading, Polica read, Set<Polica> ostalePolice) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.email = mail;
        this.lozinka = lozinka;
        this.datumRodjenja = datumRodjenja;
        this.profilnaSlika = profilnaSlika;
        this.opis = opis;
        this.uloga = uloga;
        this.aktivnost = aktivnost;
        this.knjige = knjige;
        this.ostalePolice = ostalePolice;
    }

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.ime = autor.getIme();
        this.prezime = autor.getPrezime();
        this.korisnickoIme = autor.getKorisnickoIme();
        this.email = autor.getEmail();
        this.lozinka = autor.getLozinka();
        this.datumRodjenja = autor.getDatumRodjenja();
        this.profilnaSlika = autor.getProfilnaSlika();
        this.opis = autor.getOpis();
        this.uloga = autor.getUloga();
        this.aktivnost = autor.isAktivnost();
        this.knjige = autor.getKnjige();
        this.ostalePolice = autor.getOstalePolice();
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

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
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

    public Set<Polica> getOstalePolice() {
        return ostalePolice;
    }

    public void setOstalePolice(Set<Polica> ostalePolice) {
        this.ostalePolice = ostalePolice;
    }
}
