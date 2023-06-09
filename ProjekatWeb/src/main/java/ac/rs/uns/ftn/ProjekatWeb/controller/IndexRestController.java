package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.LoginDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.RegistrationDto;
import ac.rs.uns.ftn.ProjekatWeb.service.KorisnikService;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestController {

    @Autowired
    private KorisnikService korisnikService;

    @RequestMapping("/api/")
    public String index (){
        return "This is index page stand in";
    }

    @PostMapping("api/login")
    public ResponseEntity<String> login (@RequestBody LoginDto logInDto, HttpSession session){
        if (logInDto.getEmail().isEmpty()){
            return new ResponseEntity<>("Nepostojece korisnicko ime.", HttpStatus.BAD_REQUEST);
        }
        if (logInDto.getLozinka().isEmpty()){
            return new ResponseEntity<>("Niste uneli sifru.", HttpStatus.BAD_REQUEST);
        }

        System.out.println("email " + logInDto.getEmail());
        System.out.println("pass " + logInDto.getLozinka());


        Korisnik loggedUser = korisnikService.login(logInDto.getEmail(), logInDto.getLozinka());

        if (loggedUser == null){
            return new ResponseEntity<>("korisnik", HttpStatus.NOT_FOUND);
        }

        session.setAttribute("korisnik", loggedUser);
        return ResponseEntity.ok("Uspesno ulogovano.");
    }

    @PostMapping("api/logout")
    public ResponseEntity<String> logout(HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser == null){
            return new ResponseEntity<>("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        session.invalidate();

        return ResponseEntity.ok("Uspesno odjavljeno.");
    }

    @PostMapping("/api/registracija")
    public ResponseEntity<String> saveKorisnik (@RequestBody RegistrationDto registrationDto){

//        if (registrationDto.getLozinka() != registrationDto.getPotvrdaLozinke()){
//            return new ResponseEntity<>("Lozinke se ne poklapaju!", HttpStatus.FORBIDDEN);
//        }

        Korisnik k = new Korisnik();
        k.setIme(registrationDto.getIme());
        k.setPrezime(registrationDto.getPrezime());
        k.setKorisnickoIme(registrationDto.getKorisnickoIme());
        k.setEmail(registrationDto.getMail());
        k.setLozinka(registrationDto.getLozinka());
        korisnikService.save(k);
        return new ResponseEntity<>("Uspesno ste se registrovali", HttpStatus.OK);
    }

}



