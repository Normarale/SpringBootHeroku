
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Persona;
import com.desarrollo.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService  implements IPersonaService{

    @Autowired
    private PersonaRepository persoRep;
    
    @Override
    public List<Persona> getPersonas() {
       List<Persona> listaPersonas = persoRep.findAll();
       return listaPersonas;
    }

    @Override
    public void savePersona(Persona pers) {
        persoRep.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        persoRep.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
       Persona pers = persoRep.findById(id).orElse(null);
      return pers;
    }  

    

    
}
