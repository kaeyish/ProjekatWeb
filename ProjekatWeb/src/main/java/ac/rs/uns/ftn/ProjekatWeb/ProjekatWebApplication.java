package ac.rs.uns.ftn.ProjekatWeb;

import ac.rs.uns.ftn.ProjekatWeb.entity.Status;
import ac.rs.uns.ftn.ProjekatWeb.entity.ZahtevAktivacija;
import ac.rs.uns.ftn.ProjekatWeb.repository.ZahtevAktivacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ProjekatWebApplication implements CommandLineRunner {

    @Autowired
    private ZahtevAktivacijaRepository zahtevRepository;

    @Override
    public void run (String... args){
//		ZahtevAktivacija zahtev = new ZahtevAktivacija();
//		zahtev.setEmail("email@yahoo.com");
//		zahtev.setPoruka("zahtev u toku");
//		zahtev.setStatus(Status.ODOBREN);
//		zahtev.setTelefon("+1 234 567 89");
//		zahtev.setDatum(new Date(121,1,1));
//		this.zahtevRepository.save(zahtev);

        //System.out.println(zahtev.getStatus());

    }
    public static void main(String[] args) {
        SpringApplication.run(ProjekatWebApplication.class, args);
    }

}
