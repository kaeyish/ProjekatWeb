package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.service.CitalacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitalacController {
    @Autowired
    private CitalacService citalacService;

    @GetMapping("/api")
    public String welcome(){
        return "Hello from api!";
    }
}
