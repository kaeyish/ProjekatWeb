package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Recenzija;
import ac.rs.uns.ftn.ProjekatWeb.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecenzijaService {

    @Autowired
    private RecenzijaRepository recenzijaRepository;

    public Recenzija findOne (Long id){
        Optional<Recenzija> foundRecenzija = recenzijaRepository.findById(id);

        if (foundRecenzija.isPresent())
            return foundRecenzija.get();
        return null;
    }

    public List<Recenzija> findAll (){return recenzijaRepository.findAll();}


}
