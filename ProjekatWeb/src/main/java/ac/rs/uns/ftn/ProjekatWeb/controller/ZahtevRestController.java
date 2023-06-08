package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.ZahtevDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Uloga;
import ac.rs.uns.ftn.ProjekatWeb.entity.ZahtevAktivacija;
import ac.rs.uns.ftn.ProjekatWeb.service.ZahtevAktivacijaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZahtevRestController {

    @Autowired
    private ZahtevAktivacijaService zahtevAktivacijaService;

    @GetMapping("/api/zahtevi")
    public ResponseEntity<List<ZahtevDto>> getZahtevi (HttpSession session){
        List<ZahtevAktivacija> zahtevAktivacijaList = zahtevAktivacijaService.findAll();

        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");
        if (loggedUser == null){
            System.out.println("Nema sesije");
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }

        if(loggedUser.getUloga()!= Uloga.ADMINISTRATOR){
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }

        List<ZahtevDto> dtos = new ArrayList<>();
        for (ZahtevAktivacija zahtevAktivacija: zahtevAktivacijaList){
            ZahtevDto dto = new ZahtevDto(zahtevAktivacija);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/api/zahtevi/{id}")
    public ResponseEntity<ZahtevDto> getZahtev(@PathVariable (name = "id") Long id, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser == null){
            System.out.println("Nema sesije");
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }

        if(loggedUser.getUloga()!= Uloga.ADMINISTRATOR){
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }

        ZahtevDto dto = new ZahtevDto(zahtevAktivacijaService.findOne(id));
        return  ResponseEntity.ok(dto);
    }

    @PostMapping("/api/novi-zahtev")
    public ResponseEntity saveZahtev (@RequestBody ZahtevAktivacija zahtevAktivacija, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser != null){
            System.out.println("Zahtev moze postaviti samo neulogovan korisnik");
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }

        zahtevAktivacijaService.saveZahtev(zahtevAktivacija);
        return new ResponseEntity("Zahtev uspesno sacuvan", HttpStatus.OK);

    }


}
