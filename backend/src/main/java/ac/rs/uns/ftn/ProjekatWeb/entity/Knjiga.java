package ac.rs.uns.ftn.ProjekatWeb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Knjiga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naslov;

    @Column
    private String naslovnaFotografija;

    @Column(unique = true)
    private String isbn;

    @Column
    private Date datumObjavljivanja;

    @Column
    private int brojStrana;

    @Column
    private String opis;

    @Column
    private float ocena;

    @OneToOne
    private Zanr zanr;

    //povezivanje sa autorom
    //@JsonBackReference
    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Autor autor;

    public Knjiga() {
    }

    public Knjiga(String naslov, String naslovnaFotografija, String isbn, Date datumObjavljivanja, int brojStrana, String opis, float ocena, Zanr zanr) {
        this.naslov = naslov;
        this.naslovnaFotografija = naslovnaFotografija;
        this.isbn = isbn;
        this.datumObjavljivanja = datumObjavljivanja;
        this.brojStrana = brojStrana;
        this.opis = opis;
        this.ocena = ocena;
        this.zanr = zanr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovnaFotografija() {
        return naslovnaFotografija;
    }

    public void setNaslovnaFotografija(String naslovnaFotografija) {
        this.naslovnaFotografija = naslovnaFotografija;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(Date datumObjavljivanja) {
        this.datumObjavljivanja = datumObjavljivanja;
    }

    public int getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "id=" + id +
                ", naslov='" + naslov + '\'' +
                ", naslovnaFotografija='" + naslovnaFotografija + '\'' +
                ", isbn=" + isbn +
                ", datumObjavljivanja=" + datumObjavljivanja +
                ", brojStrana=" + brojStrana +
                ", opis='" + opis + '\'' +
                ", ocena=" + ocena +
                ", autor=" + autor +
                ", zanr=" + zanr +
                '}';
    }
}
