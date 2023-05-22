package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Autor;
import ac.rs.uns.ftn.ProjekatWeb.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public Autor findOne(Long id){
        Optional<Autor> foundAutor = autorRepository.findById(id);
        if (foundAutor.isPresent()){
            return foundAutor.get();
        }
        return null;
    }

    public List<Autor> findAll(){
        return autorRepository.findAll();
    }
}
