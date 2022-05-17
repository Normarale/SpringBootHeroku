
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Tecnologia;
import com.desarrollo.portfolio.repository.TecnologiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService implements ITecnologia{
    
     @Autowired
    private TecnologiaRepository tecRepo;

    @Override
    public List<Tecnologia> getTecnologia() {
         List<Tecnologia> listaTecnologia = tecRepo.findAll();
       return listaTecnologia;
    }

    @Override
    public void saveTecnologia(Tecnologia tec) {
        tecRepo.save(tec);
    }

    @Override
    public void deleteTecnologia(Long id) {
        tecRepo.deleteById(id);
    }

    @Override
    public Tecnologia buscarTecnologia(Long id) {
       Tecnologia tec = tecRepo.findById(id).orElse(null);
       return tec;
    }
    
}
