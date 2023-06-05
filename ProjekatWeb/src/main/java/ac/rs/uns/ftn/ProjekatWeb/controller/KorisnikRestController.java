package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.PolicaDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.service.KorisnikService;
import ac.rs.uns.ftn.ProjekatWeb.service.PolicaService;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Stack;

@RestController
public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private PolicaService policaService;

    @GetMapping("/api/police")
    public ResponseEntity<List<PolicaDto>> getPolice(){

        List<Polica> police = policaService.findAll();

        List<PolicaDto> dtos = new Stack<>();

        for(Polica polica : police){
            PolicaDto dto = new PolicaDto(polica);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/api/police/{id}")
    public ResponseEntity<PolicaDto> getPolica(@PathVariable(name = "id")Long id){
        Polica polica = policaService.findOne(id);
        PolicaDto dto = new PolicaDto(polica);

        if (polica==null){
            return new ResponseEntity("Polica ne postoji", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(dto);
    }


}
