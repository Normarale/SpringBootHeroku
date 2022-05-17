
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Experiencia;
import com.desarrollo.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExperienciaService implements IExperienciaService{

    
    @Autowired
    private ExperienciaRepository expRepo;
    
    
    
    @Override
    public List<Experiencia> getExperiencia() {
       List<Experiencia> listaExperiencias = expRepo.findAll();
       return listaExperiencias;
    }

    @Override
    public void saveExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public void deleteExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        Experiencia exp = expRepo.findById(id).orElse(null);
        return exp;
    }
    
    
    
}
