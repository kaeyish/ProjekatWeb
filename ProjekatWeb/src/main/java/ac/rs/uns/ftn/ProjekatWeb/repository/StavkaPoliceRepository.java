package ac.rs.uns.ftn.ProjekatWeb.repository;

import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
import ac.rs.uns.ftn.ProjekatWeb.entity.StavkaPolice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StavkaPoliceRepository extends JpaRepository<StavkaPolice, Long> {
    List<StavkaPolice> findAllByPolicaId();

    List<StavkaPolice> findAllByKnjiga(Knjiga knjiga);
}
