package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
import ac.rs.uns.ftn.ProjekatWeb.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;

    public Knjiga findOne(Long id){
        Optional <Knjiga> foundKnjiga = knjigaRepository.findById(id);
        if (foundKnjiga.isPresent()){
            return foundKnjiga.get();
        }
        return null;
    }

    public List <Knjiga> findAll (){
        return knjigaRepository.findAll();
    }

}
