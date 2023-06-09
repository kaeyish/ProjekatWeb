package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.PolicaDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.ZanrDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.*;
import ac.rs.uns.ftn.ProjekatWeb.service.KorisnikService;
import ac.rs.uns.ftn.ProjekatWeb.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class PolicaRestController {

    @Autowired
    private PolicaService policaService;

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/api/korisnik/police/{korisnik_id}")
    public ResponseEntity<List<PolicaDto>> getPolice(@PathVariable (name = "korisnik_id") Long korisnik_id){

        Korisnik korisnik = korisnikService.findOne(korisnik_id);
        Set<Polica> police = korisnik.getOstalePolice();

        police.add(korisnik.getCurrentlyReading());
        police.add(korisnik.getRead());
        police.add(korisnik.getWantToRead());

        if (police.isEmpty()){
            return new ResponseEntity("Nema polica.", HttpStatus.NOT_FOUND);
        }

        List<PolicaDto> dtos = new ArrayList<>();

        for(Polica polica : police){
            PolicaDto dto = new PolicaDto(polica);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/api/sve-police")
    public ResponseEntity<List<PolicaDto>> svePolice (HttpSession session) {

        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser.getUloga() != Uloga.ADMINISTRATOR){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        List<Polica> police = policaService.findAll();
        List<PolicaDto> dtos = new ArrayList<>();



        if (police == null){
            return new ResponseEntity("Nema polica", HttpStatus.NOT_FOUND);
        }

        for(Polica polica : police){
            PolicaDto dto = new PolicaDto(polica);
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);

    }

    @GetMapping("/police/{id}")
    public ResponseEntity<PolicaDto> getPolica(@PathVariable(name = "id")Long id){
        Polica polica = policaService.findOne(id);

        if (polica==null){
            return new ResponseEntity("Polica ne postoji", HttpStatus.NOT_FOUND);
        }

        PolicaDto dto = new PolicaDto(polica);
        return ResponseEntity.ok(dto);
    }


    @PostMapping ("/nova-polica")
    public ResponseEntity savePolica (@RequestBody Polica polica, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser == null){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        if (policaService.findByNazivAndKorisnik(polica.getNaziv(),polica.getKorisnik())!=null){
            return new ResponseEntity("Polica sa datim imenom vec postoji.", HttpStatus.BAD_REQUEST);
        }
        this.policaService.savePolica(polica);
        return new ResponseEntity("Uspesno dodavanje police.", HttpStatus.OK);
    }

    @DeleteMapping ("/brisanje-police/{id}")
    public ResponseEntity deletePolica (@PathVariable(name = "id") Long id, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

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
