package ac.rs.uns.ftn.ProjekatWeb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Polica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column
    private boolean primarna;

    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable (
            name = "stavke_na_polici",  //????
            joinColumns = @JoinColumn(
                    name = "polica_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "stavka_id", referencedColumnName = "id"
            )
    )
    private Set<StavkaPolice> stavkePolice = new HashSet<>();

    //povezivanje sa policom korisnika

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn (name = "korisnik_id")
    private Korisnik korisnik;

    public Polica() {
    }

    public Polica(String naziv, boolean primarna) {
        this.naziv = naziv;
        this.primarna = primarna;
    }

    public Set<StavkaPolice> getStavkePolice() {
        return stavkePolice;
    }

    public void setStavkePolice(Set<StavkaPolice> stavkePolice) {
        this.stavkePolice = stavkePolice;
    }

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

    @Override
    public String toString() {
        return "Polica{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", primarna=" + primarna +
                ", stavkePolice=" + stavkePolice +
                ", korisnik=" + korisnik +
                '}';
    }
}
