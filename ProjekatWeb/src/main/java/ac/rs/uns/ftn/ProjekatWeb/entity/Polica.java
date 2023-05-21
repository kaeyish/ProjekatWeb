package ac.rs.uns.ftn.ProjekatWeb.entity;

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

    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "citalac_id")
    private Citalac citalac;


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

    public Citalac getCitalac() {
        return citalac;
    }

    public void setCitalac(Citalac citalac) {
        this.citalac = citalac;
    }

    public Set<StavkaPolice> getStavkePolice() {
        return stavkePolice;
    }

    public void setStavkePolice(Set<StavkaPolice> stavkePolice) {
        this.stavkePolice = stavkePolice;
    }


    @Override
    public String toString() {
        return "Polica{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", primarna=" + primarna +
                '}';
    }
}
