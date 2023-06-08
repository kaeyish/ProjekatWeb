package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;

public class ZanrDto {
    private Long id;
    private String naziv;

    public ZanrDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZanrDto(Long id,String naziv) {
        this.naziv = naziv;
        this.id = id;
    }

    public ZanrDto(Zanr zanr){
        this.naziv = zanr.getNaziv();
        this.id = zanr.getId();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
