package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.entity.StavkaPolice;
import ac.rs.uns.ftn.ProjekatWeb.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;

    public Polica findOne (Long id){
        Optional<Polica> foundPolica = policaRepository.findById(id);

        if (foundPolica.isPresent())
            return foundPolica.get();
        return null;
    }

    public List<Polica> findAll (){return policaRepository.findAll();}

    public Polica findByNaziv (String naziv){
        Polica foundPolica = policaRepository.findByNaziv(naziv);
        return foundPolica;
    }

    public Polica findByNazivAndKorisnik(String naziv, Korisnik korisnik){
        Polica foundPolica = policaRepository.findByNazivAndKorisnik(naziv,korisnik);
        return foundPolica;
    }

    public Polica savePolica(Polica polica){ return policaRepository.save(polica);}

    public void delete(Polica polica) {policaRepository.delete(polica);}

    public List<Polica> findAllByKorisnik (Korisnik korisnik) {
        return policaRepository.findAllByKorisnik(korisnik);
    }

    public List<Polica> findAllByKorisnikId(Long korisnikId) {return policaRepository.findAllByKorisnikId(korisnikId);}

    }
