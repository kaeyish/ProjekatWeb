package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.KnjigaDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.KorisnikDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.service.KnjigaService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

public class KnjigaContoller {
    @Autowired
    private KnjigaService knjigaService;

    //prikaz svih knjiga
    @GetMapping("/api/knjige")
    public ResponseEntity<List<KnjigaDto>> getKnjige(){
        List<Knjiga> knjigeList = knjigaService.findAll();
//        Knjiga k = (Knjiga) session.getAttribute("knjiga");
//        if (k == null){
//            System.out.println("Nema sesije");
//        } else {
//            System.out.println(k.getNaslov());
//        }

        List<KnjigaDto> knjigaDto = new ArrayList<>();
        for (Knjiga knjiga : knjigeList){
            KnjigaDto dto = new KnjigaDto(knjiga);
            knjigaDto.add(dto);
        }
        return ResponseEntity.ok(knjigaDto);
    }


    //prikaz knjiga po id
    @GetMapping("/api/knjiga/{id}")
    public ResponseEntity<KnjigaDto> getKnjiga (@PathVariable Long id){
        Optional <Knjiga> k = knjigaService.finOne(id);
        if (!k.isPresent()){
            return new ResponseEntity("Knjiga nije pronadjena", HttpStatus.NOT_FOUND);
        }
        Knjiga knjiga=k.get();
        KnjigaDto knjigaDto = new KnjigaDto(
                knjiga.getId(),
                knjiga.getNaslov(),
                knjiga.getNaslovnaFotografija(),
                knjiga.getIsbn(),
                knjiga.getDatumObjavljivanja(),
                knjiga.getBrojStrana(),
                knjiga.getOpis(),
                knjiga.getOcena(),
                knjiga.getAutor(),
                knjiga.getZanr()
        );
        return new ResponseEntity<>(knjigaDto, HttpStatus.OK);
    }


    //dodavanje knjiga
    @PostMapping("/api/save-knjiga")
    public String saveKnjiga(@RequestBody Knjiga knjiga){
        this.knjigaService.save(knjiga);
        return "Knjiga je uspesno dodata!";
    }
    //brisanje knjiga
    @DeleteMapping("/api/delete-knjiga/{id}")
    public ResponseEntity<String> izbrisisKnjigu (@PathVariable Long id){
        knjigaService.deleteKnjiga(id);
        return new ResponseEntity<String>("Knjiga je uspesno obrisana",HttpStatus.OK);
    }
    //pretraga po naslovu
    @GetMapping("/api/knjige/{naslov}")
    public ResponseEntity<List<KnjigaDto>> findByNaslov(@PathVariable String naslov){
        List<Knjiga> listaKnjiga = knjigaService.findByNaslovCo(naslov);
        if (listaKnjiga != null){
            //return new ResponseEntity<>( "Nema trazene knjige",HttpStatus.NOT_FOUND);
            List<KnjigaDto> knjigaDtos = new ArrayList<>();
            for (Knjiga k : listaKnjiga){
                KnjigaDto dto = new KnjigaDto(k);
                knjigaDtos.add(dto);
            }
            return new ResponseEntity<>(knjigaDtos, HttpStatus.OK);
        }
        return new ResponseEntity("Nema knjige sa tim nazivom",HttpStatus.NOT_FOUND);
    }

}

