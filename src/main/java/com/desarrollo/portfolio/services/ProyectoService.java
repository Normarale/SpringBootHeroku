
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Proyecto;
import com.desarrollo.portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProyectoService implements IProyectoService {

    @Autowired ProyectoRepository proRepo;
    
    @Override
    public List<Proyecto> getProyecto() {
         List<Proyecto> listaProyectos = proRepo.findAll();
       return listaProyectos;
    }

    @Override
    public void saveProyecto(Proyecto pro) {
        proRepo.save(pro);
        
    }

    @Override
    public void deleteProyecto(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        Proyecto pro = proRepo.findById(id).orElse(null);
        return pro;
    }
    
}
