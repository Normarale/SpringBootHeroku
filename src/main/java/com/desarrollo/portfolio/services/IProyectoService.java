
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Proyecto;
import java.util.List;


public interface IProyectoService {
    
        public List<Proyecto> getProyecto();
    
    public void saveProyecto(Proyecto pro);
        
    public void deleteProyecto(Long id);

    public Proyecto buscarProyecto(Long id);
}
