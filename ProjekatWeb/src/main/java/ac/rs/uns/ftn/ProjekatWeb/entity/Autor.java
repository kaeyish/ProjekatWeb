package ac.rs.uns.ftn.ProjekatWeb.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Autor extends Korisnik {
    @Column
    private boolean aktivnost;

    //lista knjiga
    @OneToMany (mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set <Knjiga> knjige = new HashSet<>();

    //police
    @OneToOne
    private Polica wantToRead;

    @OneToOne
    private Polica currentlyReading;

    @OneToOne
    private Polica read;

    @OneToMany (mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set <Polica> ostalePolice = new HashSet<>();


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
        return "Autor{" +
                "aktivnost=" + aktivnost +
                ", knjige=" + knjige +
                ", wantToRead=" + wantToRead +
                ", currentlyReading=" + currentlyReading +
                ", read=" + read +
                ", ostalePolice=" + ostalePolice +
                '}';
    }
}
