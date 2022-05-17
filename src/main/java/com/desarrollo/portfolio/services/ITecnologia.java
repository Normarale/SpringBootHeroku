
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Tecnologia;

import java.util.List;


public interface ITecnologia {
       public List<Tecnologia> getTecnologia();
    
    public void saveTecnologia(Tecnologia tec);
        
    public void deleteTecnologia(Long id);

    public Tecnologia buscarTecnologia(Long id);
}
