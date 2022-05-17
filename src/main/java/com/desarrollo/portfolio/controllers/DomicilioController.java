
package com.desarrollo.portfolio.controllers;

import com.desarrollo.portfolio.models.Domicilio;
import com.desarrollo.portfolio.services.InvalidDataException;
import com.desarrollo.portfolio.models.Localidad;
import com.desarrollo.portfolio.services.IDomicilioService;
import com.desarrollo.portfolio.services.ILocalidadService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/test")

public class DomicilioController {
    
    @Autowired 
    IDomicilioService domServ;
    
    @Autowired 
    ILocalidadService locServ;
  
   
    @GetMapping("/domicilio/traer")
     public List<Domicilio> getDomicilio(){
        return domServ.getDomicilio();
   }
  
    
  @PostMapping("/domicilio/crear")

   public String CrearDomicilio(@Valid @RequestBody Domicilio dom, BindingResult resultado){
        
            Localidad local = locServ.buscarLocalidad(dom.getLocalidadId().getIdLocalidad()); 
          if (resultado.hasErrors()) {
          throw new InvalidDataException(resultado);
          
           }  else{ 
                    if(local !=null) {  
                    dom.setLocalidadId(local);
                           domServ.saveDomicilio(dom);
                          return "el domicilio fue creado exitosamente";
                    } else{
                        return" La Localidad No Existe";
                    }
                        
                     
             }
                    
   }
   
 
   
   @DeleteMapping("/domicilio/borrar/{idDomicilio}")
   public String borrarDomicilio (@PathVariable Long idDomicilio){
       domServ.deleteDomicilio(idDomicilio);
       return "El domicilio fue elimindo correctamente";
   }
   
   
   @PutMapping("/domicilio/editar/{idDomicilio}")
   
   public Domicilio editDomicilio(@PathVariable Long idDomicilio,
                              @RequestParam ("direccion") String nuevaDireccion,
                              @RequestParam ("altura") String nuevaAltura,
                              @RequestParam("localidadId") Localidad nuevaLocalidad
                              ){
       
       //buscamos el domicilio a modificar
       
       Domicilio dom = domServ.buscarDomicilio(idDomicilio);
       
      dom.setDireccion(nuevaDireccion);
      dom.setAltura(nuevaAltura);
      dom.setLocalidadId(nuevaLocalidad);
       
       
       domServ.saveDomicilio(dom);
       return dom;
   }
    
    
}
