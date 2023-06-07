package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
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
        Optional<StavkaPolice> stavkaPolice =  stavkaPoliceRepository.findById(id);

        if (stavkaPolice.isPresent()){
            return stavkaPolice.get();
        }
        return null;
    }

    public List<StavkaPolice> findAll (){return stavkaPoliceRepository.findAll();}

    public List<StavkaPolice> findAllByPolicaId() {return stavkaPoliceRepository.findAllByPolicaId();}

    public void saveStavka(StavkaPolice stavkaPolice) { stavkaPoliceRepository.save(stavkaPolice);}

    public void deleteStavka(StavkaPolice stavkaPolice) {stavkaPoliceRepository.delete(stavkaPolice);}

    public List<StavkaPolice> findAllByKnjiga(Knjiga knjiga) {return stavkaPoliceRepository.findAllByKnjiga(knjiga);}
}
