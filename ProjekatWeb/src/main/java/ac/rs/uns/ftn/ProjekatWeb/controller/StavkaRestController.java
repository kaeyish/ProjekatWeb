package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.StavkaDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.entity.StavkaPolice;
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

    @GetMapping("/*/police/{id}/stavke_police/")
    public ResponseEntity<List<StavkaDto>> getStavka(@PathVariable (name = "polica_id") Long id){
        Polica polica = policaService.findOne(id);
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

    @GetMapping("/*/stavke_police/{id}")
    public ResponseEntity<StavkaDto> getStavke(@PathVariable(name = "id") Long id){
        StavkaPolice stavkaPolice = stavkaService.findOne(id);

        if (stavkaPolice==null){
            return new ResponseEntity("Nema stavki.", HttpStatus.NOT_FOUND);
        }
        StavkaDto dto= new StavkaDto(stavkaPolice);
        return ResponseEntity.ok(dto);
    }

    @PostMapping ("/*/police/{id}/nova-stavka")
    public ResponseEntity saveStavka (@RequestBody StavkaPolice stavkaPolice, @PathVariable (name = "polica_id") Long polica_id, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("Korisnik");

        if (loggedUser == null){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        Polica polica = policaService.findOne(polica_id);
        Set<StavkaPolice> stavkaList = polica.getStavkePolice();

        if (stavkaList.contains(stavkaPolice)){
              return new ResponseEntity("Stavka sa datim imenom vec postoji na zeljenoj.", HttpStatus.BAD_REQUEST);
        }

        List<Polica> police = policaService.findALlByStavkaPolice(stavkaPolice);

        int i=0;

        for (Polica temp : police){
            if (temp.isPrimarna()){
                i++;
            }
        }

        if (i>0 && polica.isPrimarna()){
            return new ResponseEntity("Polica je vec na nekoj od primarnih polica", HttpStatus.FORBIDDEN);
        }


        this.stavkaService.saveStavka(stavkaPolice);
        return new ResponseEntity("Uspesno dodavanje police.", HttpStatus.OK);

    }

    @DeleteMapping("/*/police/{id}/brisanje-stavke/{id}")
    public ResponseEntity deleteStavka (@PathVariable (name = "polica_id")Long polica_id,@PathVariable (name = "id")Long id, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("Korisnik");

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
