package ac.rs.uns.ftn.ProjekatWeb.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class StavkaPolice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL) //manytoone
    @JoinColumn (name = "knjiga_id")
    private Knjiga knjiga;

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Recenzija recenzija;

    public StavkaPolice() {

    }

    public StavkaPolice(Knjiga knjiga, Recenzija recenzija) {
        this.knjiga = knjiga;
        this.recenzija = recenzija;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Recenzija recenzija) {
        this.recenzija = recenzija;
    }

    @Override
    public String toString() {
        return "StavkaPolice{" +
                "id=" + id +
                ", knjiga=" + knjiga +
                ", recenzija=" + recenzija +
                '}';
    }
}
