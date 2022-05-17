
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Empleo;
import com.desarrollo.portfolio.repository.EmpleoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleoService implements IEmpleoService{
    
    @Autowired
    private EmpleoRepository empRepo;
    
    @Override
    public List<Empleo> getEmpleo() {
        List<Empleo> listaEmpleos = empRepo.findAll();
       return listaEmpleos;
    }

    @Override
    public void saveEmpleo(Empleo emp) {
        empRepo.save(emp);
    }

    @Override
    public void deleteEmpleo(Long idEmpleo) {
       empRepo.deleteById(idEmpleo);
    }

    @Override
    public Empleo buscarEmpleo(Long idEmpleo) {
       Empleo emp = empRepo.findById(idEmpleo).orElse(null);
       return emp;
    }
    
}
