package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.ZahtevDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.ZahtevAktivacija;
import ac.rs.uns.ftn.ProjekatWeb.service.ZahtevAktivacijaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZahtevRestController {

    @Autowired
    private ZahtevAktivacijaService zahtevAktivacijaService;

    @GetMapping("/api/zahtevi")
    public ResponseEntity<List<ZahtevDto>> getZahtevi (HttpSession session){
        List<ZahtevAktivacija> zahtevAktivacijaList = zahtevAktivacijaService.findAll();

        // uslov za proveru sesije? proveriti da li je ulogovani korisnik admin, ako nije vratiti error

        List<ZahtevDto> dtos = new ArrayList<>();
        for (ZahtevAktivacija zahtevAktivacija: zahtevAktivacijaList){
            ZahtevDto dto = new ZahtevDto(zahtevAktivacija);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/api/zahtevi/{id}")
    public ZahtevAktivacija getZagtev(@PathVariable (name = "id") Long id, HttpSession session){
       // ZahtevAktivacija zahtevAktivacija = (ZahtevAktivacija) session.getAttribute() ??
        return zahtevAktivacijaService.findOne(id);
    }


}
