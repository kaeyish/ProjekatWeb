package ac.rs.uns.ftn.ProjekatWeb.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Autor extends Korisnik {
    @Column
    private boolean aktivnost;

    //spisak knjiga
    @OneToMany (mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set <Knjiga> knjige = new HashSet<>();

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
