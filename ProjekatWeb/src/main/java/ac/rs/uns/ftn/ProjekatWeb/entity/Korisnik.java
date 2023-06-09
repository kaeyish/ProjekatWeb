package ac.rs.uns.ftn.ProjekatWeb.entity;

import jakarta.persistence.*;
import org.springframework.core.io.buffer.DataBufferLimitException;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(unique = true)
    private String korisnickoIme;

    @Column (unique = true)
    private String email;

    @Column
    private String lozinka;

    @Column
    private Date datumRodjenja;

    @Column
    private String profilnaSlika;

    @Column
    private String opis;

    @Column
    @Enumerated(EnumType.STRING)
    private Uloga uloga;

    //police
    @OneToOne
    private Polica wantToRead;

    @OneToOne
    private Polica currentlyReading;

    @OneToOne
    private Polica read;

    @OneToMany (mappedBy = "korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set <Polica> ostalePolice = new HashSet<>();


    public Korisnik() {
    }


    public Korisnik(String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, Uloga uloga, Polica wantToRead, Polica currentlyReading, Polica read) {
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

    public boolean setKorisnickoIme(String korisnickoIme) {
        try {
            this.korisnickoIme = korisnickoIme;
        }
        catch (DataBufferLimitException exception){
            return false;
        }
            return true;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String mail) {
        try {
            this.email = mail;
        }
        catch (DataBufferLimitException e){
            return false;
        }
        return true;
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

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", mail='" + email + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", profilnaSlika='" + profilnaSlika + '\'' +
                ", opis='" + opis + '\'' +
                ", uloga=" + uloga +
                ", wantToRead=" + wantToRead +
                ", currentlyReading=" + currentlyReading +
                ", read=" + read +
                ", ostalePolice=" + ostalePolice +
                '}';
    }
}
