
package com.desarrollo.portfolio.controllers;

import com.desarrollo.portfolio.models.Localidad;
import com.desarrollo.portfolio.services.ILocalidadService;
import com.desarrollo.portfolio.services.InvalidDataException;
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
public class LocalidadController {
    
    @Autowired
    private ILocalidadService locServ;
    
    
     @GetMapping("/localidad/traer")
   public List<Localidad> getLocalidad(){
        return locServ.getLocalidad();
   }
  
    
   
   @PostMapping("/localidad/crear")
   public String CrearLocalidad(@Valid @RequestBody Localidad loc,  BindingResult resultado){
       if (resultado.hasErrors()) {
          throw new InvalidDataException(resultado);
           }  else{    
                    locServ.saveLocalidad(loc);
                    return "la localidad fue creada exitosamente";
                   }
       
   }
   
   
   @DeleteMapping("/localidad/borrar/{id}")
   public String borrarlocalidad (@PathVariable Long idLocalidad){
       locServ.deleteLocalidad(idLocalidad);
       return "La localidad fue elimindad correctamente";
   }
   
   
   @PutMapping("/localidad/editar/{idLocalidad}")
   
   public Localidad editLocalidad(@PathVariable Long idLocalidad, @RequestBody Localidad loc                   
                              
                              ){
       
       //buscamos la localidad a modificar
       
      Localidad local = locServ.buscarLocalidad(idLocalidad);
       if (local != null) {
           local.setIdLocalidad(idLocalidad);
           local.setCodigoPostal(loc.getCodigoPostal());
           local.setLocalidad(loc.getLocalidad());
       }
            
      locServ.saveLocalidad(local);
       return local;
   }
   
    
}
