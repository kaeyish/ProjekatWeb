package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.dto.ZanrDto;
import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;
import ac.rs.uns.ftn.ProjekatWeb.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZanrService {
    @Autowired
    ZanrRepository zanrRepository;

    public Optional<Zanr> findAllById(Long id){
        return zanrRepository.findAllById(id);
    }

    public List<Zanr> findAll(){
        return zanrRepository.findAll();
    }

    public Zanr dodajZanr (ZanrDto zanrDto){
        //Zanr z = new Zanr(naziv);
        Zanr z = new Zanr(zanrDto.getNaziv());
        zanrRepository.save(z);
        return z;
    }

    public List<Zanr> findByNaziv (String n){return zanrRepository.findAllByNaziv(n);}
}
