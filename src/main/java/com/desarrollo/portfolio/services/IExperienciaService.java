
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    public List<Experiencia> getExperiencia();
    
     public void saveExperiencia(Experiencia exp);
        
    public void deleteExperiencia(Long id);

    public Experiencia buscarExperiencia(Long id);
    
}
