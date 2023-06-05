package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.KnjigaDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
import ac.rs.uns.ftn.ProjekatWeb.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KnjigaContoller {
    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/api/knjige")
    public ResponseEntity<List<KnjigaDto>> getKnjige (){
        List<Knjiga> knjigaList = knjigaService.findAll();

        List<KnjigaDto> dtos = new ArrayList<>();
        for (Knjiga knjiga : knjigaList){
            KnjigaDto dto = new KnjigaDto(knjiga);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }


}
