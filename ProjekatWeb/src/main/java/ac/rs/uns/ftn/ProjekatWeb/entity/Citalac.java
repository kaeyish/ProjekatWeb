package ac.rs.uns.ftn.ProjekatWeb.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Citalac extends Korisnik {

    @OneToOne
    private Polica wantToRead;

    @OneToOne
    private Polica currentlyReading;

    @OneToOne
    private Polica read;

    @OneToMany (mappedBy = "citalac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set <Polica> ostalePolice = new HashSet<>();

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
        return "Citalac{" +
                "wantToRead=" + wantToRead +
                ", currentlyReading=" + currentlyReading +
                ", read=" + read +
                ", ostalePolice=" + ostalePolice +
                '}';
    }
}