package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Citalac;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Recenzija;

import java.util.Date;

public class RecenzijaDto {
     private Long id;

     private int ocena;

     private String tekst;

     private Date datum;

    // private Korisnik korisnik;

    public RecenzijaDto() {
    }

    public RecenzijaDto(Recenzija recenzija) {
        this.id = recenzija.getId();
        this.ocena = recenzija.getOcena();
        this.tekst = recenzija.getTekst();
        this.datum = recenzija.getDatum();
      //  this.korisnik = recenzija.getKorisnik();
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
//
//    public Korisnik getKorisnik() {
//        return korisnik;
//    }
//
//    public void setKorisnik(Korisnik korisnik) {
//        this.korisnik = korisnik;
//    }

    public RecenzijaDto(Long id, int ocena, String tekst, Date datum, Korisnik korisnik) {
        this.id = id;
        this.ocena = ocena;
        this.tekst = tekst;
        this.datum = datum;
//        this.korisnik = korisnik;
    }
}
