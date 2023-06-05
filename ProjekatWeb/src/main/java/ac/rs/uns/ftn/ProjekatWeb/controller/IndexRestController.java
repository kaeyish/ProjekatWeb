package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.LoginDto;
import ac.rs.uns.ftn.ProjekatWeb.dto.PolicaDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.service.KorisnikService;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Stack;

@RestController
public class IndexRestController {

        @Autowired
        private KorisnikService korisnikService;

        @Autowired
        private PolicaService policaService;

        @RequestMapping("/api/")
        public ResponseEntity index (HttpSession session){

            Korisnik loggedUser = (Korisnik) session.getAttribute("Korisnik");

            if (loggedUser != null){

                List<Polica> police = policaService.findAllByKorisnik(loggedUser);

                List<PolicaDto> dtos = new Stack<>();

                for(Polica polica : police){
                    PolicaDto dto = new PolicaDto(polica);
                    dtos.add(dto);
                }
                return ResponseEntity.ok(dtos);

            }


            return new ResponseEntity("This is index page stand in", HttpStatus.OK);
        }

        @PostMapping("api/login")
        public ResponseEntity<String> login (@RequestBody LoginDto logInDto, HttpSession session){
            if (logInDto.getEmail().isEmpty()){
                return new ResponseEntity<>("Nepostojece korisnicko ime.", HttpStatus.BAD_REQUEST);
            }
            if (logInDto.getPassword().isEmpty()){
                return new ResponseEntity<>("Niste uneli sifru.", HttpStatus.BAD_REQUEST);
            }

            Korisnik loggedUser = korisnikService.login(logInDto.getEmail(), logInDto.getPassword());

            if (loggedUser == null){
                return new ResponseEntity<>("Nepostojeci korisnik", HttpStatus.NOT_FOUND);
            }

            session.setAttribute("user", loggedUser);
            return ResponseEntity.ok("Uspesno ulogovano.");
        }

        @PostMapping("api/logout/")
        public ResponseEntity logout(HttpSession session){
            Korisnik loggedUser = (Korisnik) session.getAttribute("Korisnik");

            if (loggedUser == null){
                return new ResponseEntity("Nemate pristup ovoj stranici", HttpStatus.FORBIDDEN);
            }

            session.invalidate();

            return ResponseEntity.ok("Uspesno odjavljeno.");
        }



    }



