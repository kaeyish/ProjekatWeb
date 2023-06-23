package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.KorisnikDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.LoginDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.RegistrationDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Uloga;
import ac.rs.uns.ftn.ProjekatWeb.service.KorisnikService;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class IndexRestController {

    @Autowired
    private KorisnikService korisnikService;

    @RequestMapping("/api/")
    public String index (){
        return "This is index page stand in";
    }

    @PostMapping("api/login")
    public ResponseEntity<KorisnikDto> login (@RequestBody LoginDto logInDto, HttpSession session){
        if (logInDto.getEmail()==null){
            return new ResponseEntity("Nepostojece korisnicko ime.", HttpStatus.BAD_REQUEST);
        }
        if (logInDto.getLozinka()==null){
            return new ResponseEntity("Niste uneli sifru.", HttpStatus.BAD_REQUEST);
        }

        System.out.println("email " + logInDto.getEmail());
        System.out.println("pass " + logInDto.getLozinka());


        Korisnik loggedUser = korisnikService.login(logInDto.getEmail(), logInDto.getLozinka());

        if (loggedUser == null){
            return new ResponseEntity("korisnik", HttpStatus.NOT_FOUND);
        }

        KorisnikDto dto = new KorisnikDto(loggedUser);

        session.setAttribute("korisnik", loggedUser);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @CrossOrigin(origins = "localhost:8081/index")
    @PostMapping("api/logout")
    public ResponseEntity<KorisnikDto> logout(HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser == null){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        session.invalidate();
        KorisnikDto dto = new KorisnikDto(loggedUser);
        return new  ResponseEntity(loggedUser, HttpStatus.OK);
    }

    @PostMapping("/api/registracija")
    public ResponseEntity<KorisnikDto> saveKorisnik (@RequestBody RegistrationDto registrationDto){

        if (registrationDto.getLozinka() == null){
            return new ResponseEntity("Niste uneli lozinku", HttpStatus.BAD_REQUEST);
        }


        if (registrationDto.getPotvrdaLozinke() == null){
            return new ResponseEntity("Niste uneli potvrdu lozinke", HttpStatus.BAD_REQUEST);
        }

        System.out.println("REZULTAT POREDJENJA "+registrationDto.getLozinka().equals(registrationDto.getPotvrdaLozinke()));

        if (!registrationDto.getLozinka().equals(registrationDto.getPotvrdaLozinke())){
            System.out.println("pass " + registrationDto.getLozinka() + " potvrda" + registrationDto.getPotvrdaLozinke());
            return new ResponseEntity("Lozinke se ne poklapaju!", HttpStatus.FORBIDDEN);
        }

        Korisnik postojeci = korisnikService.findByEmail(registrationDto.getMail());

        if (postojeci != null){
            return new ResponseEntity("Mejl vec postoji", HttpStatus.BAD_REQUEST);
        }

        Korisnik postojeci2= korisnikService.findByKorisnickoIme(registrationDto.getKorisnickoIme());

        if (postojeci2 != null){
            return new ResponseEntity("Korisnicko ime vec postoji vec postoji", HttpStatus.BAD_REQUEST);
        }

        korisnikService.register(registrationDto);
        Korisnik k = new Korisnik();
        k.setIme(registrationDto.getIme());
        k.setPrezime(registrationDto.getPrezime());
        k.setKorisnickoIme(registrationDto.getKorisnickoIme());
       k.setEmail(registrationDto.getMail());
        k.setLozinka(registrationDto.getLozinka());
        k.setUloga(Uloga.CITALAC);
        KorisnikDto dto = new KorisnikDto(k);

        return new ResponseEntity(dto, HttpStatus.OK);
    }

}