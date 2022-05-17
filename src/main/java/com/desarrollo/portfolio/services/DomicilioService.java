
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Domicilio;
import com.desarrollo.portfolio.repository.DomicilioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService implements IDomicilioService {
    
    @Autowired
    private DomicilioRepository domRepo;

    @Override
    public List<Domicilio> getDomicilio() {
       
       List<Domicilio> listaDomicilio = domRepo.findAll();
       return listaDomicilio;
    }

    @Override
    public void saveDomicilio(Domicilio dom) {
        
        domRepo.save(dom);
    }

    @Override
    public void deleteDomicilio(Long idDomicilio) {
        domRepo.deleteById(idDomicilio);
    }

    @Override
    public Domicilio buscarDomicilio(Long idDomicilio) {
       Domicilio dom = domRepo.findById(idDomicilio).orElse(null);
       return dom;
    }

}