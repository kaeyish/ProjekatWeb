package ac.rs.uns.ftn.ProjekatWeb.repository;

import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository <Korisnik, Long> {
    Korisnik getByEmail (String mail);
}
