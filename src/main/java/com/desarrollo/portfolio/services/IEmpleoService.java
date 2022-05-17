
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Empleo;
import java.util.List;

public interface IEmpleoService {
    
    public List<Empleo> getEmpleo();
    
    public void saveEmpleo(Empleo emp);
        
    public void deleteEmpleo(Long idEmpleo);

    public Empleo buscarEmpleo(Long idEmpleo);
}
