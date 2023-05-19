package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
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

}
