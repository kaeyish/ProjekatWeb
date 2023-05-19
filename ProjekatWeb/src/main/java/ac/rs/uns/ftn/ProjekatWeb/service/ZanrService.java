package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Zanr;
import ac.rs.uns.ftn.ProjekatWeb.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZanrService {

    @Autowired
    private ZanrRepository zanrRepository;

    public Zanr findOne (Long id){
        Optional<Zanr> foundZanr = zanrRepository.findById(id);

        if (foundZanr.isPresent())
            return foundZanr.get();
        return null;
    }

    public List<Zanr> findAll (){return zanrRepository.findAll();}


}
