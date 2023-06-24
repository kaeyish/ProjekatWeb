package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Autor;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.repository.AutorRepository;
import ac.rs.uns.ftn.ProjekatWeb.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private PolicaService policaService;

    @Autowired
    private PolicaRepository policaRepository;

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
    public Autor aktivirajAutora(Autor autor, String email, String korisnicko_ime, String lozinka) {
        autor.setEmail(email);
        autor.setAktivnost(!autor.isAktivnost());
        autor.setKorisnickoIme(korisnicko_ime);
        autor.setLozinka(lozinka);
        Autor a = new Autor(email, korisnicko_ime, lozinka);
        Polica read = new Polica("Read", true);
        Polica currently_reading = new Polica("Currently Reading", true);
        Polica want_to_read = new Polica("Want to Read", true);

        policaService.savePolica(read);
        policaService.savePolica(currently_reading);
        policaService.savePolica(want_to_read);

        read.setKorisnik(autor);
        currently_reading.setKorisnik(autor);
        want_to_read.setKorisnik(autor);

        Set<Polica> police = autor.getOstalePolice();

        police.add(read);
        police.add(currently_reading);
        police.add(want_to_read);

        autor.setOstalePolice(police);
        autorRepository.save(autor);
        return autor;
    }
}
