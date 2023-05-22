package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;

public class LogInDto {

    private String username;

    private String password;

    public LogInDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LogInDto (Korisnik korisnik){
        this.username = korisnik.getKorisnickoIme();
        this.password = korisnik.getLozinka();
    }


    public LogInDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
