package ac.rs.uns.ftn.ProjekatWeb.entity;

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
    private int isbn;

    @Column
    private Date datumObjavljivanja;

    @Column
    private int brojStrana;

    @Column
    private String opis;

    @Column
    private float ocena;

    //povezivanje sa autorom
    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Autor autor;

    //dodati zanr -> knjiga moze imati vise zanrova
    @ManyToMany
    @JoinTable (name = "zanrovi_knjiga",
            joinColumns = @JoinColumn(name = "knjiga_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "zanr_id", referencedColumnName = "id"))
    private Set <Zanr> zanrovi = new HashSet<>();


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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
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

    public Set<Zanr> getZanrovi() {
        return zanrovi;
    }

    public void setZanrovi(Set<Zanr> zanrovi) {
        this.zanrovi = zanrovi;
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
                ", zanrovi=" + zanrovi +
                '}';
    }
}
