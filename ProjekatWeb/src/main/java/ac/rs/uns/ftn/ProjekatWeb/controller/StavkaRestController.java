package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.StavkaDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.StavkaPolice;
import ac.rs.uns.ftn.ProjekatWeb.service.StavkaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StavkaRestController {
    @Autowired
    private StavkaService stavkaService;

    @GetMapping("/api/stavke_police")
    public ResponseEntity<List<StavkaDto>> getEmployees(HttpSession session){
        List<StavkaPolice> stavkaList = stavkaService.findAll();

       //provera sesije

        List<StavkaDto> dtos = new ArrayList<>();
        for(StavkaPolice stavkaPolice : stavkaList){
            StavkaDto dto = new StavkaDto(stavkaPolice);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/api/stavke_police/{id}")
    public StavkaPolice getStavke(@PathVariable(name = "id") Long id, HttpSession session){
        return stavkaService.findOne(id);
    }

}
