package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Administrator;

import java.util.Date;

public class AdministratorDto {
    private Long id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String email;
    private String lozinka;
    private Date datumRodjenja;
    private String profilnaSlika;
    private String opis;

    public AdministratorDto() {
    }

    public AdministratorDto(Long id, String ime, String prezime, String korisnickoIme, String mail, String lozinka, Date datumRodjenja, String profilnaSlika, String opis) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.email = mail;
        this.lozinka = lozinka;
        this.datumRodjenja = datumRodjenja;
        this.profilnaSlika = profilnaSlika;
        this.opis = opis;
    }
    public AdministratorDto (Administrator administrator){
        this.id = administrator.getId();
        this.ime = administrator.getIme();
        this.prezime = administrator.getPrezime();
        this.korisnickoIme = administrator.getKorisnickoIme();
        this.email = administrator.getEmail();
        this.lozinka = administrator.getLozinka();
        this.datumRodjenja = administrator.getDatumRodjenja();
        this.profilnaSlika = administrator.getProfilnaSlika();
        this.opis = administrator.getOpis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getProfilnaSlika() {
        return profilnaSlika;
    }

    public void setProfilnaSlika(String profilnaSlika) {
        this.profilnaSlika = profilnaSlika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
