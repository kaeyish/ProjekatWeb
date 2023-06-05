package ac.rs.uns.ftn.ProjekatWeb.dto;

import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;

public class LoginDto {

    private String email;

    private String password;

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginDto (Korisnik korisnik){
        this.email = korisnik.getEmail();
        this.password = korisnik.getLozinka();
    }


    public LoginDto() {
    }



    public String getEmail() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
