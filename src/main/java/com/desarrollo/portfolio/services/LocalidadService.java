
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Localidad;
import com.desarrollo.portfolio.repository.LocalidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadService implements ILocalidadService{
                                       
    @Autowired
    private LocalidadRepository locRepo;

    @Override
    public List<Localidad> getLocalidad() {
         List<Localidad> listaLocalidad = locRepo.findAll();
       return listaLocalidad;
    }

    @Override
    public void saveLocalidad(Localidad loc) {
        locRepo.save(loc);
    }

    @Override
    public void deleteLocalidad(Long idLocalidad) {
        locRepo.deleteById(idLocalidad);
    }

    @Override
    public Localidad buscarLocalidad(Long idLocalidad) {
        Localidad loc = locRepo.findById(idLocalidad).orElse(null);
        
          return loc;
        
    }
    
}
