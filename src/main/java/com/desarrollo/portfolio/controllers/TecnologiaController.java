
package com.desarrollo.portfolio.controllers;

import com.desarrollo.portfolio.models.Tecnologia;
import com.desarrollo.portfolio.services.ITecnologia;
import com.desarrollo.portfolio.services.InvalidDataException;
import java.util.List;
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
public class TecnologiaController {
    
    
    @Autowired ITecnologia tecServ;
    
    
     @GetMapping("/tecnologia/traer")
   public List<Tecnologia> getTecnologia(){
        return tecServ.getTecnologia();
   }
  
    
   
  @PostMapping("/tecnologia/crear")
   public String CrearTecnologia(@RequestBody Tecnologia tec,  BindingResult resultado){
       
       if (resultado.hasErrors()) {
          throw new InvalidDataException(resultado);
           }  else{ 
                     tecServ.saveTecnologia(tec);
                      return "la tecnología fue creada exitosamente";
                    }
   }
  
   
   @DeleteMapping("/tecnologia/borrar/{id}")
   public String borrarTecnologia (@PathVariable Long id){
       tecServ.deleteTecnologia(id);
       return "El tipo de tecnología fue eliminada correctamente";
   }
   
   
   @PutMapping("/tecnologia/editar/{id}")
   
   public Tecnologia editTecnologia(@PathVariable Long id,
                                  @RequestParam("tecnologia") String nuevaTecnologia
                              ){
       
       //buscamos el Tipo de empleo a modificar
       
      Tecnologia tec = tecServ.buscarTecnologia(id);
       
       tec.setTecnologia(nuevaTecnologia);
       
       
       tecServ.saveTecnologia(tec);
       return tec;
   }
    
    
    
    
}
