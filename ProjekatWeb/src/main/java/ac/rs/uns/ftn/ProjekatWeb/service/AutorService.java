package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Autor;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.entity.Uloga;
import ac.rs.uns.ftn.ProjekatWeb.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public Autor findOne(Long id) {
        Optional<Autor> foundAutor = autorRepository.findById(id);
        if (foundAutor.isPresent()) {
            return foundAutor.get();
        }
        return null;
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    //kreiraj novog autora
    public Autor kreirajAutora(String ime, String prezime, String korisnickoIme, String email, String lozinka, Date datumRodjenja, String profilnaSlika, String opis, Uloga uloga, Polica wantToRead, Polica currentlyReading, Polica read, boolean aktivnost) {
        Autor a = new Autor(ime, prezime, korisnickoIme, email, lozinka, datumRodjenja, profilnaSlika, opis, uloga, wantToRead, currentlyReading, read, aktivnost);
        autorRepository.save(a);
        return a;
    }
}
