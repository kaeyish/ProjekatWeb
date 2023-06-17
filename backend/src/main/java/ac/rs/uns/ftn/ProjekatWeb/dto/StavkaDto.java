package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
import ac.rs.uns.ftn.ProjekatWeb.entity.Recenzija;
import ac.rs.uns.ftn.ProjekatWeb.entity.StavkaPolice;

public class StavkaDto {
    private Long id;

    private Knjiga knjiga;

    private Recenzija recenzija;

    public StavkaDto() {
    }

    public StavkaDto(StavkaPolice stavka){
        this.id = stavka.getId();
        this.knjiga = stavka.getKnjiga();
        this.recenzija = stavka.getRecenzija();
    }

    public StavkaDto(Long id, Knjiga knjiga, Recenzija recenzija) {
        this.id = id;
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
}
