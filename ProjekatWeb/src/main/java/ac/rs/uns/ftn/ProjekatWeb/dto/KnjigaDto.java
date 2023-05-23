package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Autor;
import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;

import java.util.Date;

public class KnjigaDto {
    private Long id;
    private String naslov;
    private String naslovnaFotografija;
    private String isbn;
    private Date datumObjavljivanja;
    private int brojStrana;
    private String opis;
    private float ocena;
    private Autor autor;
    private Zanr zanr;

    public KnjigaDto() {
    }

    public KnjigaDto(Long id, String naslov, String naslovnaFotografija, String isbn, Date datumObjavljivanja, int brojStrana, String opis, float ocena, Autor autor, Zanr zanr) {
        this.id = id;
        this.naslov = naslov;
        this.naslovnaFotografija = naslovnaFotografija;
        this.isbn = isbn;
        this.datumObjavljivanja = datumObjavljivanja;
        this.brojStrana = brojStrana;
        this.opis = opis;
        this.ocena = ocena;
        this.autor = autor;
        this.zanr = zanr;
    }

    public KnjigaDto (Knjiga knjiga){
        this.id = knjiga.getId();
        this.naslov = knjiga.getNaslov();
        this.naslovnaFotografija = knjiga.getNaslovnaFotografija();
        this.isbn = knjiga.getIsbn();
        this.datumObjavljivanja = knjiga.getDatumObjavljivanja();
        this.brojStrana = knjiga.getBrojStrana();
        this.opis = knjiga.getOpis();
        this.ocena = knjiga.getOcena();
        this.autor = knjiga.getAutor();
        this.zanr = knjiga.getZanr();
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
}
