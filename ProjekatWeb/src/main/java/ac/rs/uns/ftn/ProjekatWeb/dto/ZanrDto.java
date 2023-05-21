package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;

public class ZanrDto {
    private Long id;

    private String naziv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ZanrDto() {
    }

    public ZanrDto(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public ZanrDto(Zanr zanr) {
        this.id = zanr.getId();
        this.naziv = zanr.getNaziv();
    }
}
