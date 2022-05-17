
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Educacion;
import java.util.List;


public interface IEducacionService {
       public List<Educacion> getEducacion();
    
    public void saveEducacion(Educacion edu);
        
    public void deleteEducacion(Long id);

    public Educacion buscarEducacion(Long id);
}
