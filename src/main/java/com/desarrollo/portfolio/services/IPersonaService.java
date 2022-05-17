
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> getPersonas();
    
    public void savePersona(Persona pers);
        
    public void deletePersona(Long id);

    public Persona buscarPersona(Long id);
    

  
}
