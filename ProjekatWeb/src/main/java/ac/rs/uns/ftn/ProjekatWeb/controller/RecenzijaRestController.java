package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.RecenzijaDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.*;
import ac.rs.uns.ftn.ProjekatWeb.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RecenzijaRestController {

    @Autowired
    private RecenzijaService recenzijaService;

    @Autowired
    private StavkaService stavkaPoliceService;

    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/recenzije/{id}")
    public ResponseEntity<RecenzijaDto> getRecenzija (@PathVariable (name = "id") Long id){
        Recenzija recenzija = recenzijaService.findOne(id);
        RecenzijaDto recenzijaDto= new RecenzijaDto(recenzija);

        return ResponseEntity.ok(recenzijaDto);
    }

    @GetMapping ("/recenzije-korisnika/{korisnik_id}")
    public ResponseEntity<List<RecenzijaDto>> getRecenzije(@PathVariable (name = "korisnik_id") Long korisnik_id){
        List<Recenzija> recenzijaList = recenzijaService.findAllByKorisnikId(korisnik_id);

        if (recenzijaList.isEmpty()){
            return new ResponseEntity("Nema recenzija", HttpStatus.NOT_FOUND);
        }

        List<RecenzijaDto> dtos = new ArrayList<>();
        for (Recenzija recenzija: recenzijaList){
            RecenzijaDto dto = new RecenzijaDto(recenzija);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping ("/api/recenzije-knjige/{knjiga_id}")
    public ResponseEntity<List<RecenzijaDto>> getRecenzijeKnjiga(@PathVariable (name = "knjiga_id") Long knjiga_id){
        Optional<Knjiga> knjigaOptional = knjigaService.finOne(knjiga_id);

        if (!knjigaOptional.isPresent()){
            return new ResponseEntity("Knjiga ne postoji", HttpStatus.NOT_FOUND);
        }

        Knjiga knjiga = knjigaOptional.get();
        List <StavkaPolice> lista = stavkaPoliceService.findAllByKnjiga(knjiga);

        if (lista.isEmpty()){
            return new ResponseEntity("Nema recenzija", HttpStatus.NOT_FOUND);
        }


        List<RecenzijaDto> dtos = new ArrayList<>();
        for (StavkaPolice stavka: lista){
            RecenzijaDto dto = new RecenzijaDto(stavka.getRecenzija());
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }


    @PostMapping ("/nova-recenzija")
    public ResponseEntity saveRecenzija (@RequestBody Recenzija recenzija, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser == null){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        recenzija.setKorisnik(loggedUser);
        recenzijaService.save(recenzija);
        return new ResponseEntity("Recenzija Sacuvana", HttpStatus.OK);
    }

    @PutMapping("/recenzije/edit-recenzije/{id}")
    public ResponseEntity updateRecenzija (@PathVariable (name = "id")Long id, @RequestBody Recenzija recenzija, HttpSession session) {
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        if (loggedUser == null /*|| loggedUser!=recenzija.getKorisnik()*/) {
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        Recenzija recenzijaStara = recenzijaService.findOne(id);

        {
            recenzijaStara.setDatum(recenzija.getDatum());
            recenzijaStara.setOcena(recenzija.getOcena());
            recenzijaStara.setTekst(recenzija.getTekst());
        }

        recenzijaService.save(recenzijaStara);
        return new ResponseEntity("Recenzija Sacuvana", HttpStatus.OK);
    }

    @DeleteMapping("/brisanje-recenzije/{id}")
    public ResponseEntity deleteRecenzija (@PathVariable (name = "id")Long id, HttpSession session) {
        Korisnik loggedUser = (Korisnik) session.getAttribute("korisnik");

        Recenzija recenzija = recenzijaService.findOne(id);


        if (loggedUser == null /*|| loggedUser!=recenzija.getKorisnik()*/) {
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        if (recenzija==null){
            return new ResponseEntity("Ne postoji recenzija.", HttpStatus.NOT_FOUND);
        }

        recenzijaService.delete(recenzija);
        return new ResponseEntity("Recenzija izbrisana", HttpStatus.OK);
    }

    @GetMapping("/recenzije")
    public ResponseEntity<List<RecenzijaDto>> getRecenzija (HttpSession session){
        List<Recenzija> recenzijaList = recenzijaService.findAll();
                Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
                if(loggedKorisnik == null) {
                    System.out.println("Nemate pristup!");
                } else {
                    System.out.println(loggedKorisnik.getIme());
                }
                List<RecenzijaDto> dtos = new ArrayList<>();
                for (Recenzija recenzija: recenzijaList){
                    RecenzijaDto dto = new RecenzijaDto(recenzija);
                    dtos.add(dto);
                }
                return ResponseEntity.ok(dtos);

    }


}
