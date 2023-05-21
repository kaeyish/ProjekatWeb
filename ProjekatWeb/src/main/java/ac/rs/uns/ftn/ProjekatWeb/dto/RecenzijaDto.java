package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Citalac;
import ac.rs.uns.ftn.ProjekatWeb.entity.Recenzija;

import java.util.Date;

public class RecenzijaDto {
     private Long id;

     private int ocena;

     private String tekst;

     private Date datum;

     private Citalac citalac;

    public RecenzijaDto() {
    }

    public RecenzijaDto(Recenzija recenzija) {
        this.id = recenzija.getId();
        this.ocena = recenzija.getOcena();
        this.tekst = recenzija.getTekst();
        this.datum = recenzija.getDatum();
        this.citalac = (Citalac) recenzija.getKorisnik();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Citalac getCitalac() {
        return citalac;
    }

    public void setCitalac(Citalac citalac) {
        this.citalac = citalac;
    }

    public RecenzijaDto(Long id, int ocena, String tekst, Date datum, Citalac citalac) {
        this.id = id;
        this.ocena = ocena;
        this.tekst = tekst;
        this.datum = datum;
        this.citalac = citalac;
    }
}
