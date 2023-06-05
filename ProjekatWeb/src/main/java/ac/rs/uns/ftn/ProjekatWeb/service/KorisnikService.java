package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Korisnik;
import ac.rs.uns.ftn.ProjekatWeb.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik findOne(Long id){
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if (foundKorisnik.isPresent()){
            return foundKorisnik.get();
        }
        return null;
    }

    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }

    public Korisnik save (Korisnik korisnik) {return korisnikRepository.save(korisnik);}

    public Korisnik login (String email, String password){

        if (email != null && password != null){
            Korisnik loggedUser = korisnikRepository.findByEmail(email);
            if (loggedUser.getLozinka()==password)
                return loggedUser;
        }

        return null;
    }

}
