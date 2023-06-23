package ac.rs.uns.ftn.ProjekatWeb.configuration;

import ac.rs.uns.ftn.ProjekatWeb.entity.*;
import ac.rs.uns.ftn.ProjekatWeb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
        Polica p4 = new Polica("Want to read",true);
        Polica p5 = new Polica("Read", true);
        Polica p6 = new Polica("Currently reading", true);
        Polica p7 = new Polica("Want to read",true);
        Polica p8 = new Polica("Read", true);
        Polica p9 = new Polica("Currently reading", true);
        Polica p10 = new Polica("Want to read",true);
        Polica p11 = new Polica("Read", true);
        Polica p12 = new Polica("Currently reading", true);
        Polica p13 = new Polica("Want to read",true);
        Polica p14 = new Polica("Read", true);
        Polica p15 = new Polica("Currently reading", true);
        Polica p16 = new Polica("Books that made me cry", false);
        policaRepository.save(p1);
        policaRepository.save(p2);
        policaRepository.save(p3);
        policaRepository.save(p4);
        policaRepository.save(p5);
        policaRepository.save(p6);
        policaRepository.save(p7);
        policaRepository.save(p8);
        policaRepository.save(p9);
        policaRepository.save(p10);
        policaRepository.save(p11);
        policaRepository.save(p12);
        policaRepository.save(p13);
        policaRepository.save(p14);
        policaRepository.save(p15);
        policaRepository.save(p16);
        Recenzija r1 = new Recenzija(5, "Ovde ide tekst recenzije.", Date.from(Instant.now()));

        StavkaPolice sp1 = new StavkaPolice(knjiga1,r1);
        //stavkaPoliceRepository.save(sp1);

        Korisnik k1 = new Korisnik("Imenko","Prezimenko","korisnicko123","imenko@gmail.com","pass123", Date.from(Instant.now()),"profilna.com","ovo je neki opis", Uloga.CITALAC);
        Korisnik k2 = new Korisnik("Andjela","Petkovic","brownotter","andjela@gmail.com","lozinka123", Date.from(Instant.now()),"www.profilna.com","ovo moj je neki opis",Uloga.ADMINISTRATOR);
        Korisnik k3 = new Korisnik("Dusanka","Ignjatovic","kaeyish","ignjatovicdusanka02@gmail.com","lozinka123", Date.from(Instant.now()),"https://i1.sndcdn.com/artworks-fXyz5P9cIIrdinYK-Zm1JgA-t500x500.jpg","ovo moj je neki opis",Uloga.ADMINISTRATOR);

        Set<Polica> police = k1.getOstalePolice();
        police.add(p1);        police.add(p2);        police.add(p3);
        Set<Polica> police1 = k2.getOstalePolice();
        police1.add(p4);        police1.add(p5);        police1.add(p6);
        Set<Polica> police2 = k3.getOstalePolice();
        police2.add(p7);        police2.add(p8);        police2.add(p9);

        korisnikRepository.save(k1);
        korisnikRepository.save(k2);
        korisnikRepository.save(k3);
        r1.setKorisnik(k1);
        recenzijaRepository.save(r1);

        ZahtevAktivacija za1= new ZahtevAktivacija(Status.NA_CEKANJU,"mejl@gmail","060005500","Ovo je poruka",Date.from(Instant.now()));
        zahtevAktivacijaRepository.save(za1);

        Citalac c1 = new Citalac("Ana","Anic","anana","aninmejl@hotmail.com","lozinka",Date.from(Instant.now()),"njenaslika.rs","Ovo je moj profil",Uloga.CITALAC);
        Autor a1 = new Autor("J.R.R","Tolkien","jrrtolkien","jrr@tolkien.com","jrrpass",Date.from(Instant.now()),"JRRslika","Pisac knjiga",Uloga.AUTOR,true);

        Set<Polica> police3 = c1.getOstalePolice();
        police3.add(p10);        police.add(p11);        police.add(p12);
        Set<Polica> police4 = a1.getOstalePolice();
        police4.add(p14);        police4.add(p15);        police4.add(p13);


        citalacRepository.save(c1);
        autorRepository.save(a1);
        knjiga1.setAutor(a1);
        knjigaRepository.save(knjiga1);



        p1.setKorisnik(k1);
        p2.setKorisnik(k1);
        p3.setKorisnik(k1);
        p4.setKorisnik(k2);
        p5.setKorisnik(k2);
        p6.setKorisnik(k2);
        p7.setKorisnik(k3);
        p8.setKorisnik(k3);
        p9.setKorisnik(k3);
        p10.setKorisnik(c1);
        p11.setKorisnik(c1);
        p12.setKorisnik(c1);
        p13.setKorisnik(a1);
        p14.setKorisnik(a1);
        p15.setKorisnik(a1);

        policaRepository.save(p1);
        policaRepository.save(p2);
        policaRepository.save(p3);
        policaRepository.save(p4);
        policaRepository.save(p5);
        policaRepository.save(p6);
        policaRepository.save(p7);
        policaRepository.save(p8);
        policaRepository.save(p9);
        policaRepository.save(p10);
        policaRepository.save(p11);
        policaRepository.save(p12);
        policaRepository.save(p13);
        policaRepository.save(p14);
        policaRepository.save(p15);


        return true;
    }

}
