package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.ZahtevAktivacija;
        import ac.rs.uns.ftn.ProjekatWeb.repository.ZahtevAktivacijaRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import javax.swing.text.html.Option;
        import java.util.List;
        import java.util.Optional;

@Service
public class ZahtevAktivacijaService {

    @Autowired
    private ZahtevAktivacijaRepository zahtevAktivacijaRepository;

    public ZahtevAktivacijaRepository getZahtevAktivacijaRepository() {
        return zahtevAktivacijaRepository;
    }

    public ZahtevAktivacija findOne (Long id){
        Optional<ZahtevAktivacija> foundZahtev = zahtevAktivacijaRepository.findById(id);
        if (foundZahtev.isPresent())
            return  foundZahtev.get();
        return null;
    }

    public List<ZahtevAktivacija> findAll () {return zahtevAktivacijaRepository.findAll();}





}
