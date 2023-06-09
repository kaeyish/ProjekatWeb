package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.PolicaDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.StavkaDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.entity.StavkaPolice;
import ac.rs.uns.ftn.ProjekatWeb.entity.Uloga;
import ac.rs.uns.ftn.ProjekatWeb.service.PolicaService;
import ac.rs.uns.ftn.ProjekatWeb.service.StavkaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class StavkaRestController {
    @Autowired
    private StavkaService stavkaService;

    @Autowired
    private PolicaService policaService;

    @GetMapping("/police/stavke_police/{polica_id}")
    public ResponseEntity<List<StavkaDto>> getStavka(@PathVariable (name = "polica_id") Long polica_id){
        Polica polica = policaService.findOne(polica_id);
        Set<StavkaPolice> stavkaList = polica.getStavkePolice();

        if (stavkaList.isEmpty()){
            return new ResponseEntity("Nema stavki", HttpStatus.NOT_FOUND);
        }

        List<StavkaDto> dtos = new ArrayList<>();
        for(StavkaPolice stavkaPolice : stavkaList){
            StavkaDto dto = new StavkaDto(stavkaPolice);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping ("/api/sve-stavke")
    public ResponseEntity<List<StavkaDto>> sveStavke (HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser.getUloga() != Uloga.ADMINISTRATOR){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        List<StavkaPolice> stavke = stavkaService.findAll();
        List<StavkaDto> dtos = new ArrayList<>();



        if (stavke == null){
            return new ResponseEntity("Nema polica", HttpStatus.NOT_FOUND);
        }

        for(StavkaPolice stavka : stavke){
            StavkaDto dto = new StavkaDto(stavka);
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);

    }

    @GetMapping("/stavke_police/{id}")
    public ResponseEntity<StavkaDto> getStavke(@PathVariable(name = "id") Long id){
        StavkaPolice stavkaPolice = stavkaService.findOne(id);

        if (stavkaPolice==null){
            return new ResponseEntity("Nema stavki.", HttpStatus.NOT_FOUND);
        }
        StavkaDto dto= new StavkaDto(stavkaPolice);
        return ResponseEntity.ok(dto);
    }

    @PostMapping ("/nova-stavka/{id}")
    public ResponseEntity saveStavka (@RequestBody StavkaPolice stavkaPolice, @PathVariable (name = "id") Long polica_id, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser == null){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        Polica polica = policaService.findOne(polica_id);
        Set<StavkaPolice> stavkaList = polica.getStavkePolice();

        System.out.println(stavkaList);

        for (StavkaPolice stavka: stavkaList){
            if (stavka.getKnjiga().getId()==stavkaPolice.getKnjiga().getId()){
                return new ResponseEntity("Stavka vec postoji na zeljenoj.", HttpStatus.BAD_REQUEST);
            }
        }

       if(this.stavkaService.proveriPrimarne(stavkaPolice)){
           return new ResponseEntity("Stavka sa datim imenom vec postoji na nekoj od primarnih.", HttpStatus.BAD_REQUEST);
       }

        this.stavkaService.saveStavka(stavkaPolice);
        stavkaList.add(stavkaPolice);
        polica.setStavkePolice(stavkaList);
        policaService.savePolica(polica);
        return new ResponseEntity("Dodata na policu.", HttpStatus.OK);

    }

    @DeleteMapping("/brisanje-stavke/{polica_id}/{id}")
    public ResponseEntity deleteStavka (@PathVariable (name = "polica_id")Long polica_id,@PathVariable (name = "id")Long id, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser == null){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        StavkaPolice stavkaPolice = stavkaService.findOne(id);
        Polica polica = policaService.findOne(polica_id);


        if (stavkaPolice == null){
            return new ResponseEntity("Stavka ne postoji", HttpStatus.NOT_FOUND);
        }

        if (polica.isPrimarna()){
            List<StavkaPolice> stavke = stavkaService.findAllByKnjiga(stavkaPolice.getKnjiga());

            for(StavkaPolice stavka : stavke){
                stavkaService.deleteStavka(stavka);
            }
            return new ResponseEntity("Izbrisana.", HttpStatus.OK);
        }
        stavkaService.deleteStavka(stavkaPolice);
        return new ResponseEntity("Izbrisana.", HttpStatus.OK);
    }
}
