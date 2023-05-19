package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.StavkaPolice;
import ac.rs.uns.ftn.ProjekatWeb.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StavkaService {
    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    public StavkaPolice findOne (Long id){
        Optional<StavkaPolice> foundStavka = stavkaPoliceRepository.findById(id);

        if (foundStavka.isPresent())
            return foundStavka.get();
        return null;
    }

    public List<StavkaPolice> findAll (){return stavkaPoliceRepository.findAll();}


}
