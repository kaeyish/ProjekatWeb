package ac.rs.uns.ftn.ProjekatWeb.controller;

import ac.rs.uns.ftn.ProjekatWeb.dto.*;
import ac.rs.uns.ftn.ProjekatWeb.entity.*;
import ac.rs.uns.ftn.ProjekatWeb.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin

public class KorisnikContoller {
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private PolicaService policaService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private CitalacService citalacService;
    @Autowired
    private ZanrService zanrService;
    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/hello")
    public String welcome() {
        return "Hello there!";
    }

    //neprijavljeni vidi korisnika, zanrove, police, recnezije, knjige

    //prikaz korisnik po id
    @GetMapping ("/api/korisnik/{id}")
    public ResponseEntity <KorisnikDto> getKorisnik (@PathVariable Long id){
        Korisnik korisnik = korisnikService.findOne(id);
        if (korisnik == null){
            return new ResponseEntity("Korisnik nije pronadjen",HttpStatus.NOT_FOUND);
        }
        KorisnikDto kdto = new KorisnikDto(
                korisnik.getId(),
                korisnik.getIme(),
                korisnik.getPrezime(),
                korisnik.getKorisnickoIme(),
                korisnik.getEmail(),
                korisnik.getLozinka(),
                korisnik.getDatumRodjenja(),
                korisnik.getProfilnaSlika(),
                korisnik.getOpis(),
                korisnik.getUloga(),
                korisnik.getOstalePolice()
        );
        return new ResponseEntity<>(kdto, HttpStatus.OK);
    }

    //prikaz svih korisnika
    @GetMapping("/api/korisnici")
    public ResponseEntity<List<KorisnikDto>> getKorisnici(HttpSession session){
        List<Korisnik> korisnikList = korisnikService.findAll();

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null) {
            System.out.println("Nemate pristup!");
        } else {
            System.out.println(loggedKorisnik.getIme());
        }

        List<KorisnikDto> dtos = new ArrayList<>();
        for(Korisnik korisnik : korisnikList){
            KorisnikDto dto = new KorisnikDto(korisnik);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    //dodavanje korisnika
    @PostMapping("/api/korisnik/save")
    public ResponseEntity<KorisnikDto> saveKorisnik (@RequestBody Autor autor){
//        if (korisnik.getUloga().equals(Uloga.ADMINISTRATOR)){
//            return new ResponseEntity<>("Ne moze se dodati admin!",HttpStatus.FORBIDDEN);
//        }
        Polica read = new Polica("Read", true);
        Polica currently_reading = new Polica("Currently Reading", true);
        Polica want_to_read = new Polica("Want to Read", true);

        policaService.savePolica(read);
        policaService.savePolica(currently_reading);
        policaService.savePolica(want_to_read);

        read.setKorisnik(autor);
        currently_reading.setKorisnik(autor);
        want_to_read.setKorisnik(autor);

        Set<Polica> police = autor.getOstalePolice();

        police.add(read);
        police.add(currently_reading);
        police.add(want_to_read);

        autor.setOstalePolice(police);

        autor.setAktivnost(false);

        autor.setUloga(Uloga.AUTOR);

        this.korisnikService.save(autor);
        return  new ResponseEntity("Neaktivni autor je uspesno sacuvan",HttpStatus.OK);
    }

    //brisanje korisnika
    @DeleteMapping("/api/korisnik/delete/{id}")
    public ResponseEntity <KorisnikDto> izbrisiKorisnika (@PathVariable Long id){
        korisnikService.deleteKorisnik(id);
        return new ResponseEntity("Korisnik je uspesno izbrisan", HttpStatus.OK);
    }


    //azuriranje profila od strane korisnika
    @PostMapping("/api/korisnik/azuriranje-profila")
    public ResponseEntity<KorisnikDto> azuriranjeProfila(@RequestBody KorisnikDto korisnikDto,HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if (korisnik == null){
            return new ResponseEntity("Nemate pristup!", HttpStatus.NOT_FOUND);
        }
        //azuriranje
        korisnik.setIme(korisnikDto.getIme() == null ? korisnik.getIme() : korisnikDto.getIme());
        korisnik.setPrezime(korisnikDto.getPrezime() == null ? korisnik.getPrezime() : korisnikDto.getPrezime());
        korisnik.setOpis(korisnikDto.getOpis() == null ? korisnik.getOpis() : korisnikDto.getOpis());
        korisnik.setProfilnaSlika(korisnikDto.getProfilnaSlika() == null ? korisnik.getProfilnaSlika() : korisnikDto.getProfilnaSlika());
        korisnik.setDatumRodjenja(korisnikDto.getDatumRodjenja()== null ? korisnik.getDatumRodjenja() : korisnikDto.getDatumRodjenja());

        //ne moze da promeni mejl i lozinku ako je pogresna lozink
//            if (korisnikDto.getLozinka()!= null && korisnikDto.getLozinka() != korisnik.getLozinka()){
//                return new ResponseEntity<>("Niste uneli tacnu lozinku, ne mozete promeniti podatke!",HttpStatus.FORBIDDEN);
//            }
        korisnik.setEmail(korisnikDto.getEmail() == null ? korisnik.getEmail() : korisnikDto.getEmail());
        //lozinka postaje nova lozinka
        korisnik.setLozinka(korisnikDto.getNovaLozinka() == null ? korisnik.getLozinka() : korisnikDto.getNovaLozinka());

        korisnikService.save(korisnik);
        return new ResponseEntity("Podaci su azurirani", HttpStatus.OK);
    }

    //autor moze da doda svoje nove knjige
    @PostMapping("api/korisnik/dodaj-novu-knjigu")
    public ResponseEntity<KnjigaDto> novaKnjiga(@RequestBody KnjigaDto knjigaDto, HttpSession session){
        Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (prijavljeniKorisnik == null){
            return new ResponseEntity("Nemate pristup!", HttpStatus.NOT_FOUND);
        }
        if (prijavljeniKorisnik.getUloga().equals(Uloga.AUTOR)){
            Knjiga novaKnjiga = new Knjiga();
            novaKnjiga.setNaslov(knjigaDto.getNaslov());
            novaKnjiga.setIsbn(knjigaDto.getIsbn());
            novaKnjiga.setNaslovnaFotografija(knjigaDto.getNaslovnaFotografija());
            novaKnjiga.setBrojStrana(knjigaDto.getBrojStrana());
            novaKnjiga.setOpis(knjigaDto.getOpis());
            novaKnjiga.setDatumObjavljivanja(knjigaDto.getDatumObjavljivanja());
            novaKnjiga.setAutor(knjigaDto.getAutor());
            novaKnjiga.setZanr(knjigaDto.getZanr());

            knjigaService.save(novaKnjiga);
        }
        return new ResponseEntity("Knjiga je dodata",HttpStatus.OK
        );

    }

    //autor moze da azurira svoje knjige
    @PutMapping("/api/korisnik/azuriranje-knjige/{id}")
    public ResponseEntity<KnjigaDto> azurirajKnjiguAutor (@PathVariable Long id, @RequestBody KnjigaDto knjigaDto, HttpSession session){
        Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (prijavljeniKorisnik == null){
            return new ResponseEntity("Nemate pristup!",HttpStatus.NOT_FOUND);
        }
        if (prijavljeniKorisnik.getUloga().equals(Uloga.AUTOR)){
            Optional<Knjiga> stara = knjigaService.finOne(id);
            if(stara.isPresent()){
                stara.get().setNaslov(knjigaDto.getNaslov()==null ? stara.get().getNaslov() : knjigaDto.getNaslov());
                stara.get().setNaslovnaFotografija(knjigaDto.getNaslovnaFotografija() == null ? stara.get().getNaslovnaFotografija() : knjigaDto.getNaslovnaFotografija());
                stara.get().setIsbn(knjigaDto.getIsbn() == null ? stara.get().getIsbn() : knjigaDto.getIsbn());
                stara.get().setBrojStrana(knjigaDto.getBrojStrana());
                stara.get().setAutor(knjigaDto.getAutor() == null ? stara.get().getAutor() : knjigaDto.getAutor());
                stara.get().setDatumObjavljivanja(knjigaDto.getDatumObjavljivanja() == null ? stara.get().getDatumObjavljivanja() : knjigaDto.getDatumObjavljivanja());
                stara.get().setOpis(knjigaDto.getOpis() == null ? stara.get().getOpis() : knjigaDto.getOpis());
                stara.get().setZanr(knjigaDto.getZanr() == null ? stara.get().getZanr() : knjigaDto.getZanr());

                knjigaService.save(stara.get());
                return new ResponseEntity("Podaci knjige su uspesno azurirani!",HttpStatus.OK);
            }
        }
        return new ResponseEntity("Samo autor moze da azurira svoje knjige",HttpStatus.FORBIDDEN);
    }

    //admin dodaje autora i aktivira mu nalog
    @PostMapping("/api/korisnik/kreiranjeAutora")
    public ResponseEntity <KorisnikDto> kreirajAutora(@RequestBody ZahtevAktivacija zahtevAktivacija, HttpSession session){
        Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (prijavljeniKorisnik == null){
            return new ResponseEntity("Nemate pristup!",HttpStatus.NOT_FOUND);
        }
        if (prijavljeniKorisnik.getUloga().equals(Uloga.ADMINISTRATOR)){
            String korisnicko_ime = UUID.randomUUID().toString().substring(0,7);
            String lozinka = UUID.randomUUID().toString().substring(0,7);

            autorService.aktivirajAutora(zahtevAktivacija.getAutor(),zahtevAktivacija.getEmail(), korisnicko_ime,lozinka);


            return new ResponseEntity("Autor je uspesno kreiran!",HttpStatus.OK);
        }
        return new ResponseEntity("Ova opcija je dozvoljena samo administratorima!",HttpStatus.FORBIDDEN);
    }
    //admin dodaje zanr
    @PostMapping("/api/korisnik/dodajZanr")
    public ResponseEntity<ZanrDto> dodajZanr(@RequestBody ZanrDto zanrDto, HttpSession session){
        Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (prijavljeniKorisnik == null){
            return new ResponseEntity("Nemate pristup!",HttpStatus.NOT_FOUND);
        }
        if (prijavljeniKorisnik.getUloga().equals(Uloga.ADMINISTRATOR)) {
            if (zanrDto.getNaziv().isEmpty()) {
                return new ResponseEntity("Polja ne smeju biti prazna!", HttpStatus.BAD_REQUEST);
            }
            zanrService.dodajZanr(zanrDto);
            return new ResponseEntity("Zanr je uspeno dodat", HttpStatus.OK);
        }
        return new ResponseEntity("Ova opcija je dozvoljena samo administratorima", HttpStatus.FORBIDDEN);
    }


    //admin azurira knjige
    @PutMapping("/api/korisnik/knjiga/{id}/azuriranje")
    public ResponseEntity<KnjigaDto> azuriranjeKnjiga(@PathVariable Long id, @RequestBody KnjigaDto knjigaDto, HttpSession session) {
        Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (prijavljeniKorisnik == null){
            return new ResponseEntity("Nemate pristup",HttpStatus.NOT_FOUND);
        } // Ažuriranje knjige
        if (prijavljeniKorisnik.getUloga().equals(Uloga.ADMINISTRATOR)){
            Optional<Knjiga> stara = knjigaService.finOne(id);
            if(stara.isPresent()){
                stara.get().setNaslov(knjigaDto.getNaslov()==null ? stara.get().getNaslov() : knjigaDto.getNaslov());
                stara.get().setNaslovnaFotografija(knjigaDto.getNaslovnaFotografija() == null ? stara.get().getNaslovnaFotografija() : knjigaDto.getNaslovnaFotografija());
                stara.get().setIsbn(knjigaDto.getIsbn() == null ? stara.get().getIsbn() : knjigaDto.getIsbn());
                stara.get().setBrojStrana(knjigaDto.getBrojStrana());
                stara.get().setAutor(knjigaDto.getAutor() == null ? stara.get().getAutor() : knjigaDto.getAutor());
                stara.get().setDatumObjavljivanja(knjigaDto.getDatumObjavljivanja() == null ? stara.get().getDatumObjavljivanja() : knjigaDto.getDatumObjavljivanja());
                stara.get().setOpis(knjigaDto.getOpis() == null ? stara.get().getOpis() : knjigaDto.getOpis());
                stara.get().setZanr(knjigaDto.getZanr() == null ? stara.get().getZanr() : knjigaDto.getZanr());

                knjigaService.save(stara.get());
                return new ResponseEntity("Uspesno promenuti podaci knjige", HttpStatus.OK);
            }
        }
        return new ResponseEntity("Ova opcija je dozvoljena samo administratorima", HttpStatus.FORBIDDEN);
    }
    //admin moze da doda knjigu
    @PostMapping("/api/korisnik/dodaj-knjigu")
    public ResponseEntity<KnjigaDto> saveKnjiga(@RequestBody Knjiga knjiga, HttpSession session){
        Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (prijavljeniKorisnik == null) {
            return new ResponseEntity("Nemate pristu!",HttpStatus.NOT_FOUND);
        }
        if (prijavljeniKorisnik.getUloga().equals(Uloga.ADMINISTRATOR)){
            this.knjigaService.save(knjiga);
            return new ResponseEntity("Knjiga je uspesno dodata!",HttpStatus.OK);
        }
        return new ResponseEntity("Ova opcija je dozvoljena samo administratorima!",HttpStatus.FORBIDDEN);
    }
    //admin moze da obrise knjigu
    @DeleteMapping("/api/korisnik/obrisi-knjigu/{id}")
    public ResponseEntity izbrisisKnjigu (@PathVariable Long id, HttpSession session){
        Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (prijavljeniKorisnik == null) {
            return new ResponseEntity("Nemate pristup",HttpStatus.NOT_FOUND);
        }
        if (prijavljeniKorisnik.getUloga().equals(Uloga.ADMINISTRATOR)) {
            knjigaService.deleteKnjiga(id);
            return new ResponseEntity("Knjiga je uspesno obrisana", HttpStatus.OK);
        }
        return new ResponseEntity("Ova opcija je dozvoljena samo administratorima!",HttpStatus.FORBIDDEN);
    }
    //admin azurira profil autora ako mu je neaktivan
    @PostMapping("/api/korisnik/azuriranje-profila/{id}")
    public ResponseEntity<KorisnikDto> azuriranjeProfila(@PathVariable Long id, @RequestBody AutorDto autorDto, HttpSession session) {
        Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (prijavljeniKorisnik == null) {
            return new ResponseEntity("Nemate pristup", HttpStatus.NOT_FOUND);
        }// Ažuriranje
        if (prijavljeniKorisnik.getUloga().equals(Uloga.ADMINISTRATOR)) {
            Autor a = autorService.findOne(id);
            if (a != null && !a.isAktivnost()) {
                a.setIme(autorDto.getIme() == null ? a.getIme() : autorDto.getIme());
                a.setPrezime(autorDto.getPrezime() == null ? a.getPrezime() : autorDto.getPrezime());
                a.setKorisnickoIme(autorDto.getKorisnickoIme() == null ? a.getKorisnickoIme() : autorDto.getKorisnickoIme());
                a.setLozinka(autorDto.getLozinka() == null ? a.getLozinka() : autorDto.getLozinka());
                a.setEmail(autorDto.getEmail()== null ? a.getEmail() : autorDto.getEmail());
                a.setDatumRodjenja(autorDto.getDatumRodjenja() == null ? a.getDatumRodjenja() :autorDto.getDatumRodjenja());
                a.setOpis(autorDto.getOpis() == null ? a.getOpis() : autorDto.getOpis());
                a.setProfilnaSlika(autorDto.getProfilnaSlika() == null ? a.getProfilnaSlika() : autorDto.getProfilnaSlika());
                a.setKnjige(autorDto.getKnjige() == null ? a.getKnjige() : autorDto.getKnjige());
                a.setAktivnost(autorDto.isAktivnost());
                return new ResponseEntity("Uspesno promenuti podaci citalaca", HttpStatus.OK);
            }
            return new ResponseEntity("Autor ne postoji", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Ova opcija je dozvoljena samo administratorima!", HttpStatus.FORBIDDEN);
    }
}
