package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.dto.RegistrationDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.entity.Uloga;
import ac.rs.uns.ftn.ProjekatWeb.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private PolicaService policaService;

    public Korisnik findOne(Long id){
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if (foundKorisnik.isPresent()){
            return foundKorisnik.get();
        }
        return null;
    }
    // public Optional <Korisnik> findOne(Long id){
    //    return korisnikRepository.findById(id);
    //}

    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }

    public Korisnik login(String mail, String lozinka){
        Korisnik korisnik = korisnikRepository.getByEmail(mail);
        if (korisnik == null || !korisnik.getLozinka().equals(lozinka)){
            return null;
        }
        return korisnik;
    }

    public Korisnik save(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }

    public void deleteKorisnik (long id){
        korisnikRepository.deleteById(id);
    }


    public Korisnik findByEmail(String mail) {
        return korisnikRepository.getByEmail(mail);
    }

    public Korisnik findByKorisnickoIme(String korisnickoIme) {
      return  korisnikRepository.findByKorisnickoIme(korisnickoIme);
    }

    public void register(RegistrationDto registrationDto) {
//String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, Uloga uloga
        Korisnik korisnik = new Korisnik(
                registrationDto.getIme(),
                registrationDto.getPrezime(),
                registrationDto.getKorisnickoIme(),
                registrationDto.getMail(),
                registrationDto.getLozinka(),
                Date.from(Instant.now()),
                "slika.com",
                "defaultni opis",
                Uloga.CITALAC
        );

        Polica read = new Polica("Read", true);
        Polica currently_reading = new Polica("Currently Reading", true);
        Polica want_to_read = new Polica("Want to Read", true);

        policaService.savePolica(read);
        policaService.savePolica(currently_reading);
        policaService.savePolica(want_to_read);

        read.setKorisnik(korisnik);
        currently_reading.setKorisnik(korisnik);
        want_to_read.setKorisnik(korisnik);

        Set<Polica> police = korisnik.getOstalePolice();

        if (police == null)
            System.out.println("Police su null");


        police.add(read);
        police.add(currently_reading);
        police.add(want_to_read);

        if (police.isEmpty())
        System.out.println("Neuspelo dodavanje???");
        else System.out.println("Police dodate.");
        korisnik.setOstalePolice(police);

        this.save(korisnik);

    }
}
