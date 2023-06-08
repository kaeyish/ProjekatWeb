package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.ZanrDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;
import ac.rs.uns.ftn.ProjekatWeb.service.ZanrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZanrContoller {
    @Autowired
    ZanrService zanrService;

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
}
