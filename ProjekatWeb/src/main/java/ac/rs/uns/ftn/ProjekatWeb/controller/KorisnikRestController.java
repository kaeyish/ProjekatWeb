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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private PolicaService policaService;


}
