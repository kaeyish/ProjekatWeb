package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Citalac;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CitalacDto {
    private Long id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String email;
    private String lozinka;
    private Date datumRodjenja;
    private String profilnaSlika;
    private String opis;
    private Polica wantToRead;
    private Polica currentlyReading;
    private Polica read;
    private Set<Polica> ostalePolice = new HashSet<>();

    public CitalacDto() {
    }

    public CitalacDto(Long id, String ime, String prezime, String korisnickoIme, String mail, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, Polica wantToRead, Polica currentlyReading, Polica read, Set<Polica> ostalePolice) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.email = mail;
        this.lozinka = lozinka;
        this.datumRodjenja = datumRodjenja;
        this.profilnaSlika = profilnaSlika;
        this.opis = opis;
        this.wantToRead = wantToRead;
        this.currentlyReading = currentlyReading;
        this.read = read;
        this.ostalePolice = ostalePolice;
    }

    public CitalacDto (Citalac citalac){
        this.id = citalac.getId();
        this.ime = citalac.getIme();
        this.prezime = citalac.getPrezime();
        this.korisnickoIme = citalac.getKorisnickoIme();
        this.email = citalac.getEmail();
        this.lozinka = citalac.getLozinka();
        this.datumRodjenja = citalac.getDatumRodjenja();
        this.profilnaSlika = citalac.getProfilnaSlika();
        this.opis = citalac.getOpis();
        this.wantToRead = citalac.getWantToRead();
        this.currentlyReading = citalac.getCurrentlyReading();
        this.read = citalac.getRead();
        this.ostalePolice = citalac.getOstalePolice();
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
}
