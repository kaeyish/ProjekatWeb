package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Autor;
import ac.rs.uns.ftn.ProjekatWeb.entity.Status;
import ac.rs.uns.ftn.ProjekatWeb.entity.ZahtevAktivacija;

import java.util.Date;

public class ZahtevDto {
    private Long id;

    private Status status;

    private String email;

    private String telefon;

    private String poruka;

    private Autor autor;

    private Date datum;

    public ZahtevDto(){}

    public ZahtevDto(Long id, Status status, String email, String telefon, String poruka, Autor autor, Date datum) {
        this.id = id;
        this.status = status;
        this.email = email;
        this.telefon = telefon;
        this.poruka = poruka;
        this.autor = autor;
        this.datum = datum;
    }

    public ZahtevDto(ZahtevAktivacija zahtevAktivacija){
        this.id = zahtevAktivacija.getId();
        this.datum = zahtevAktivacija.getDatum();
        this.email = zahtevAktivacija.getEmail();
        this.poruka = zahtevAktivacija.getPoruka();
        this.telefon = zahtevAktivacija.getTelefon();
        this.status = zahtevAktivacija.getStatus();
        this.autor = zahtevAktivacija.getAutor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
