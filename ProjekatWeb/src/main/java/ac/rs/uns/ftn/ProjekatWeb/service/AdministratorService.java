package ac.rs.uns.ftn.ProjekatWeb.service;

import ac.rs.uns.ftn.ProjekatWeb.entity.Administrator;
import ac.rs.uns.ftn.ProjekatWeb.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    public Administrator findOne(Long id){
        Optional <Administrator> foundAdministrator = administratorRepository.findById(id);
        if (foundAdministrator.isPresent()){
            return foundAdministrator.get();
        }
        return null;
    }

    public List <Administrator> findAll(){
        return administratorRepository.findAll();
    }
}
