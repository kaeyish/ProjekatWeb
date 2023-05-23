package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.RecenzijaDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.ZahtevDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Recenzija;
import ac.rs.uns.ftn.ProjekatWeb.entity.ZahtevAktivacija;
import ac.rs.uns.ftn.ProjekatWeb.service.RecenzijaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecenzijaRestController {

    @Autowired
    private RecenzijaService recenzijaService;

    @GetMapping ("/api/recenzije/")
    public ResponseEntity<List<RecenzijaDto>> getRecenzije (HttpSession session){
        List<Recenzija> recenzijaList = recenzijaService.findAll();

        List<RecenzijaDto> dtos = new ArrayList<>();
        for (Recenzija recenzija: recenzijaList){
            RecenzijaDto dto = new RecenzijaDto(recenzija);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }




}
