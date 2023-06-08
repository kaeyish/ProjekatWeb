package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Knjiga;
import ac.rs.uns.ftn.ProjekatWeb.entity.Polica;
import ac.rs.uns.ftn.ProjekatWeb.entity.StavkaPolice;
import ac.rs.uns.ftn.ProjekatWeb.repository.PolicaRepository;
import ac.rs.uns.ftn.ProjekatWeb.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StavkaService {
    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    @Autowired
    private PolicaRepository policaRepository;

    public StavkaPolice findOne (Long id){
        Optional<StavkaPolice> stavkaPolice =  stavkaPoliceRepository.findById(id);

        if (stavkaPolice.isPresent()){
            return stavkaPolice.get();
        }
        return null;
    }

    public List<StavkaPolice> findAll (){return stavkaPoliceRepository.findAll();}

    public void saveStavka(StavkaPolice stavkaPolice) { stavkaPoliceRepository.save(stavkaPolice);}

    public void deleteStavka(StavkaPolice stavkaPolice) {stavkaPoliceRepository.delete(stavkaPolice);}

    public List<StavkaPolice> findAllByKnjiga(Knjiga knjiga) {return stavkaPoliceRepository.findAllByKnjiga(knjiga);}

    public boolean proveriPrimarne(StavkaPolice stavkaPolice) {

        List<Polica> police = this.policaRepository.findAll();

        for(Polica polica : police){
            if (polica.isPrimarna()){
               Set<StavkaPolice> stavke = polica.getStavkePolice();

                for (StavkaPolice stavka: stavke){
                    if (stavka.getKnjiga().getId()==stavkaPolice.getKnjiga().getId()){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
