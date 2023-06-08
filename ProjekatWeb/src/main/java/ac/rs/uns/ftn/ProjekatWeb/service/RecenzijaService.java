package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.entity.Recenzija;
import ac.rs.uns.ftn.ProjekatWeb.repository.KorisnikRepository;
import ac.rs.uns.ftn.ProjekatWeb.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecenzijaService {

    @Autowired
    private RecenzijaRepository recenzijaRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Recenzija findOne (Long id){
        Optional<Recenzija> foundRecenzija = recenzijaRepository.findById(id);

        if (foundRecenzija.isPresent())
            return foundRecenzija.get();
        return null;
    }

    public List<Recenzija> findAll (){return recenzijaRepository.findAll();}

    public void save(Recenzija recenzija) { recenzijaRepository.save(recenzija);}

    public void delete(Recenzija recenzija) {recenzijaRepository.delete(recenzija);}


    public List<Recenzija> findAllByKorisnikId(Long korisnikId) {
        Optional<Korisnik> korisnikOptional = korisnikRepository.findById(korisnikId);

        if (!korisnikOptional.isPresent()){
            return null;
        }

        Korisnik korisnik = korisnikOptional.get();

        return recenzijaRepository.findAllByKorisnik(korisnik);
    }
}
