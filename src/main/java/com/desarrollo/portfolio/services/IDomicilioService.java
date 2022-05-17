
package com.desarrollo.portfolio.services;

import com.desarrollo.portfolio.models.Domicilio;
import java.util.List;


public interface IDomicilioService {
    
     public List<Domicilio> getDomicilio();
    
    public void saveDomicilio(Domicilio dom);
        
    public void deleteDomicilio(Long idDomicilio);

    public Domicilio buscarDomicilio(Long idDomicilio);
    
}
