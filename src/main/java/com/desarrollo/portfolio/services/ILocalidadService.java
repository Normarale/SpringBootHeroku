
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Localidad;
import java.util.List;


public interface ILocalidadService {
    
    public List<Localidad> getLocalidad();
    
    public void saveLocalidad(Localidad loc);
        
    public void deleteLocalidad(Long idLocalidad);

    public Localidad buscarLocalidad(Long idLocalidad);
    
  
    
}
