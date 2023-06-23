package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.KnjigaDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.ZanrDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;
import ac.rs.uns.ftn.ProjekatWeb.service.ZanrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

public class ZanrContoller {
    @Autowired
    ZanrService zanrService;

    //prikaz svih zanrova
    @GetMapping("/api/zanrovi")
    public ResponseEntity<List<ZanrDto>> getZanrove(){
        List<Zanr> zanrList = zanrService.findAll();

        List<ZanrDto> dtos = new ArrayList<>();
        for(Zanr zanr : zanrList){
            ZanrDto dto = new ZanrDto(zanr);
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);

    }
    @GetMapping("api/zanr/{naziv}")
    public ResponseEntity<List<ZanrDto>> findByNaziv (@PathVariable String naziv){
        List<Zanr> zanrList = zanrService.findByNaziv(naziv);
        if (zanrList != null){
            List<ZanrDto> zanrDtos = new ArrayList<>();
            for (Zanr z : zanrList){
                ZanrDto dto = new ZanrDto(z);
                zanrDtos.add(dto);
            }
            return ResponseEntity.ok(zanrDtos);
        }
        return new ResponseEntity("Nema zanra sa takvim nazivom", HttpStatus.NOT_FOUND);
    }
}
