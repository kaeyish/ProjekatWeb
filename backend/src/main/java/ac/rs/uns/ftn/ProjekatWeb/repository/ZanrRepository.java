package ac.rs.uns.ftn.ProjekatWeb.repository;

import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ZanrRepository extends JpaRepository <Zanr, Long> {
    List<Zanr> findAll();
    Optional<Zanr> findAllById(Long id);

    List<Zanr> findAllByNaziv(String naziv);
}
