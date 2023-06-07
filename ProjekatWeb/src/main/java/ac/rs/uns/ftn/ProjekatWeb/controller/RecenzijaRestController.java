package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.RecenzijaDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.ZahtevDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Recenzija;
import ac.rs.uns.ftn.ProjekatWeb.entity.ZahtevAktivacija;
import ac.rs.uns.ftn.ProjekatWeb.service.RecenzijaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecenzijaRestController {

    @Autowired
    private RecenzijaService recenzijaService;

    @GetMapping("/*/recenzije/{id}")
    public ResponseEntity<RecenzijaDto> getRecenzija (@PathVariable (name = "id") Long id){
        Recenzija recenzija = recenzijaService.findOne(id);
        RecenzijaDto recenzijaDto= new RecenzijaDto(recenzija);

        return ResponseEntity.ok(recenzijaDto);
    }

    @GetMapping ("/*/knjige/{id}/recenzije/")
    public ResponseEntity<List<RecenzijaDto>> getRecenzije(@PathVariable (name = "knjiga_id") Long knjiga_id){
        List<Recenzija> recenzijaList = recenzijaService.findAllByKnjigaId(knjiga_id);

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

    @PostMapping ("/*/nova-recenzija")
    public ResponseEntity saveRecenzija (@RequestBody Recenzija recenzija, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("Korisnik");

        if (loggedUser == null){
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        recenzijaService.save(recenzija);
        return new ResponseEntity("Recenzija Sacuvana", HttpStatus.OK);
    }

    @PutMapping("/*/recenzije/{id}/edit-recenzije/")
    public ResponseEntity updateRecenzija (@PathVariable (name = "id")Long id, @RequestBody Recenzija recenzija, HttpSession session) {
        Korisnik loggedUser = (Korisnik) session.getAttribute("Korisnik");

        if (loggedUser == null || loggedUser!=recenzija.getKorisnik()) {
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

    @DeleteMapping("/*/brisanje-recenzije{id}")
    public ResponseEntity deleteRecenzija (@PathVariable (name = "id")Long id, @RequestBody Recenzija recenzija, HttpSession session) {
        Korisnik loggedUser = (Korisnik) session.getAttribute("Korisnik");

        if (loggedUser == null || loggedUser!=recenzija.getKorisnik()) {
            return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
        }

        Recenzija recenzijaStara = recenzijaService.findOne(id);

        recenzijaService.delete(recenzija);
        return new ResponseEntity("Recenzija Sacuvana", HttpStatus.OK);
    }


}
