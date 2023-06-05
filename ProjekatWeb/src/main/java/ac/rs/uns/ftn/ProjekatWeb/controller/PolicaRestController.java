package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.PolicaDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.ZanrDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.entity.StavkaPolice;
import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;
import ac.rs.uns.ftn.ProjekatWeb.service.KorisnikService;
import ac.rs.uns.ftn.ProjekatWeb.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
public class PolicaRestController {

    @Autowired
    private PolicaService policaService;

    @Autowired
    private KorisnikService korisnikService;


    @PostMapping ("/api/nova_polica")
    public ResponseEntity savePolica (@RequestBody Polica polica, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("Korisnik");

        if (loggedUser == null){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        if (policaService.findByNazivAndKorisnik(polica.getNaziv(),polica.getKorisnik())!=null){
            return new ResponseEntity("Polica sa datim imenom vec postoji.", HttpStatus.BAD_REQUEST);
        }
        this.policaService.savePolica(polica);
        return new ResponseEntity("Uspesno dodavanje police.", HttpStatus.OK);
    }

    @DeleteMapping ("/api/police/{id}")
    public ResponseEntity<Long> deletePolica (@PathVariable(name = "id") Long id, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("Korisnik");

        if (loggedUser == null){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        Polica polica = policaService.findOne(id);

        if (polica == null){
            return new ResponseEntity("Polica ne postoji", HttpStatus.NOT_FOUND);
        }

        if (polica.isPrimarna()){
            return new ResponseEntity("Nemoguce izbrisati primarnu policu", HttpStatus.FORBIDDEN);
        }

        Korisnik korisnikUpdate = korisnikService.findOne(loggedUser.getId());
        korisnikUpdate.getOstalePolice().remove(polica);
        korisnikService.save(korisnikUpdate);
        policaService.delete(polica);

        return  new ResponseEntity("Polica uklonjena", HttpStatus.OK);
    }




}
