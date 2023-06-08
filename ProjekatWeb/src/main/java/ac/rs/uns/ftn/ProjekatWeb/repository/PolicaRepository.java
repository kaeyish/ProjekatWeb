package ac.rs.uns.ftn.ProjekatWeb.repository;

import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicaRepository extends JpaRepository<Polica, Long> {
    Polica findByNaziv(String naziv);

    Polica findByNazivAndKorisnik(String naziv, Korisnik korisnik);


    List<Polica> findAllByKorisnikId(Long korisnikId);

    List<Polica> findAllByKorisnik(Korisnik korisnik);
}
