package ac.rs.uns.ftn.ProjekatWeb.configuration;

import ac.rs.uns.ftn.ProjekatWeb.entity.*;
import ac.rs.uns.ftn.ProjekatWeb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Date;

@Configuration
public class DatabaseConfiguration {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CitalacRepository citalacRepository;
    @Autowired
    private KnjigaRepository knjigaRepository;
    @Autowired
    private ZanrRepository zanrRepository;
    @Autowired
    private ZahtevAktivacijaRepository zahtevAktivacijaRepository;
    @Autowired
    private PolicaRepository policaRepository;
    @Autowired
    private RecenzijaRepository recenzijaRepository;
    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    @Bean
    public boolean instantiate(){

        Zanr z1 = new Zanr("romantika");
        Zanr z2= new Zanr("naucna fantastika");
        Zanr z3 = new Zanr("triler");
        zanrRepository.save(z1);
        zanrRepository.save(z2);
        zanrRepository.save(z3);

        Knjiga knjiga1 = new Knjiga("The Fellowship of the rings","www.slika.com","10101",Date.from(Instant.now()),400, "Prva knjiga u serijalu",4,z2);
        Knjiga knjiga2= new Knjiga("Ime knjige","slika.com","12345",Date.from(Instant.now()),123,"Najbolja knjiga",4.5F,z1);
        knjigaRepository.save(knjiga1);
        knjigaRepository.save(knjiga2);

        Polica p1 = new Polica("Want to read",true);
        Polica p2 = new Polica("Read", true);
        Polica p3 = new Polica("Currently reading", true);
        Polica p4 = new Polica("Books that made me cry", false);
        policaRepository.save(p1);
        policaRepository.save(p2);
        policaRepository.save(p3);
        policaRepository.save(p4);

        Recenzija r1 = new Recenzija(5, "Ovde ide tekst recenzije.", Date.from(Instant.now()));
        recenzijaRepository.save(r1);

        StavkaPolice sp1 = new StavkaPolice(knjiga1,r1);
        //stavkaPoliceRepository.save(sp1);

        Korisnik k1 = new Korisnik("Imenko","Prezimenko","korisnicko123","imenko@gmail.com","pass123", Date.from(Instant.now()),"profilna.com","ovo je neki opis", Uloga.CITALAC,p1,p2,p3);
        Korisnik k2 = new Korisnik("Andjela","Petkovic","brownotter","andjela@gmail.com","lozinka123", Date.from(Instant.now()),"www.profilna.com","ovo moj je neki opis",Uloga.ADMINISTRATOR,p1,p2,p3);
        korisnikRepository.save(k1);
        korisnikRepository.save(k2);
        r1.setKorisnik(k1);

        ZahtevAktivacija za1= new ZahtevAktivacija(Status.NA_CEKANJU,"mejl@gmail","060005500","Ovo je poruka",Date.from(Instant.now()));
        zahtevAktivacijaRepository.save(za1);

        Citalac c1 = new Citalac("Ana","Anic","anana","aninmejl@hotmail.com","lozinka",Date.from(Instant.now()),"njenaslika.rs","Ovo je moj profil",Uloga.CITALAC,p1,p2,p3);
        citalacRepository.save(c1);

        Autor a1 = new Autor("J.R.R","Tolkien","jrrtolkien","jrr@tolkien.com","jrrpass",Date.from(Instant.now()),"JRRslika","Pisac knjiga",Uloga.AUTOR,p1,p2,p3,true);
        autorRepository.save(a1);
        knjiga1.setAutor(a1);
        return true;
    }

}
