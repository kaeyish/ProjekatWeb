package ac.rs.uns.ftn.ProjekatWeb.repository;

import ac.rs.uns.ftn.ProjekatWeb.entity.Autor;
import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {

    List <Knjiga> findAll();
    List <Knjiga> findAllById(Long id);
    List <Knjiga> findAllByOcena(double ocena);
    //pronalazi knjigu na osnovu autora
    List <Knjiga> findAllByAutorContaining(Autor autor);
    List<Knjiga> findAllByZanr(Zanr zanr);

    List<Knjiga> findAllByOrderByOcena();
    List<Knjiga> findAllByOrderByBrojStrana();
    List<Knjiga> findAllByOrderByDatumObjavljivanja();

    Knjiga findByNaslov(String naslov);
    Knjiga findByZanr(Zanr zanr);

}
