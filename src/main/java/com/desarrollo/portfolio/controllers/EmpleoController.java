
package com.desarrollo.portfolio.controllers;

import com.desarrollo.portfolio.models.Empleo;
import com.desarrollo.portfolio.models.Persona;
import com.desarrollo.portfolio.services.IEmpleoService;
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
public class EmpleoController {
    
    @Autowired
    private IEmpleoService empServ;
    
    
     @GetMapping("/empleo/traer")
   public List<Empleo> getEmpleo(){
        return empServ.getEmpleo();
   }
  
    
   
   @PostMapping("/empleo/crear")
   public String CrearEmpleo(@Valid @RequestBody Empleo emp, BindingResult resultado){
        if (resultado.hasErrors()) {
            throw new InvalidDataException(resultado);
             }  else{    empServ.saveEmpleo(emp);
                       return "El empleo fue creado exitosamente";
                    }  
   }
   
   
   @DeleteMapping("/empleo/borrar/{id}")
   public String borrarPersona (@PathVariable Long id){
       empServ.deleteEmpleo(id);
       return "El empleo fue elimindo correctamente";
   }
   
   
   @PutMapping("/empleo/editar/{id}")
   
   public Empleo editEmpleo(@PathVariable Long id,
                              @RequestParam ("tipo") String nuevoTipo
                             ){
       
       //buscamos el empleo a modificar
       
      Empleo emp = empServ.buscarEmpleo(id);
       
       emp.setTipo(nuevoTipo);
       
       empServ.saveEmpleo(emp);
       
       return emp;
       
      
   }
    
    
}
