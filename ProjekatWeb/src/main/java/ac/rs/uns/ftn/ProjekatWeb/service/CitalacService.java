package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Citalac;
import ac.rs.uns.ftn.ProjekatWeb.repository.CitalacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitalacService {
    @Autowired
    private CitalacRepository citalacRepository;

    public Citalac findOne(Long id){
        Optional<Citalac> foundCitalac = citalacRepository.findById(id);
        if (foundCitalac.isPresent()){
            return foundCitalac.get();
        }
        return null;
    }

    public List<Citalac> findAll(){
        return citalacRepository.findAll();
    }
}
