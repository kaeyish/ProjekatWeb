package ac.rs.uns.ftn.ProjekatWeb.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class ZahtevAktivacija implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Status status;

    @Column(unique = true, nullable = false)
    private String email;

    @Column (unique = true)
    private String telefon;

    @Column
    private String poruka;

    @Column
    private Date datum;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "autor_id")
    private Autor autor;

    @Override
    public String toString() {

        
        return "ZahtevAktivacija{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", telefon='" + telefon + '\'' +
                ", poruka='" + poruka + '\'' +
                ", datum=" + datum +
                '}';
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
