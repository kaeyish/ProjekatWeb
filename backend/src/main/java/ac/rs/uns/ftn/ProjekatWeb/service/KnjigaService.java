package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Autor;
import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;
import ac.rs.uns.ftn.ProjekatWeb.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;

    public Optional<Knjiga> finOne(Long id){
        return knjigaRepository.findById(id);
    }


    public List <Knjiga> findAll (){
        return knjigaRepository.findAll();
    }

    public List<Knjiga> findByOcena(double ocena){
        return  knjigaRepository.findAllByOcena(ocena);
    }

    public List<Knjiga> findByAutor (Autor autor){
        return  knjigaRepository.findAllByAutorContaining(autor);
    }

    public Knjiga save (Knjiga k){return knjigaRepository.save(k);}

    public void deleteKnjiga (long id){knjigaRepository.deleteById(id);}

    public Knjiga findByNaslov(String n){
        return knjigaRepository.findByNaslov(n);
    }

    public List<Knjiga> findByZanr(String naziv){
        return knjigaRepository.findByZanrNaziv(naziv);

    }

    public List<Knjiga> findByNaslovCo(String naslov){
        return knjigaRepository.findByNaslovContaining(naslov);
    }

}
