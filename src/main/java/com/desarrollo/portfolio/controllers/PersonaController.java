
package com.desarrollo.portfolio.controllers;

import com.desarrollo.portfolio.models.Domicilio;
import com.desarrollo.portfolio.models.Persona;
import com.desarrollo.portfolio.services.IDomicilioService;
import com.desarrollo.portfolio.services.IPersonaService;
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
public class PersonaController {
    
     @Autowired
    private IPersonaService interPersona;
     
     @Autowired 
    IDomicilioService domServ;
    
   @GetMapping("/persona/traer")
   public List<Persona> getPersonas(){
        return interPersona.getPersonas();
   }
  
    
   
   @PostMapping("/persona/crear")
   public String CrearPersona(@RequestBody @Valid Persona pers, BindingResult resultado){
       
            if (resultado.hasErrors()) {
          throw new InvalidDataException(resultado);
           }  else{
                      Domicilio dom = domServ.buscarDomicilio(pers.getIdDomicilio().getIdDomicilio());
            
                      if (dom != null){
                            pers.setIdDomicilio(dom);
                             interPersona.savePersona(pers);    
                       return "la persona fue creada exitosamente";
                      }else{
                          return "VER.... Domicilio nulo o inexistente ";
                      }
                }          
      
   }
   
   
   @DeleteMapping("/persona/borrar/{id}")
   public String borrarPersona (@PathVariable Long id){
       interPersona.deletePersona(id);
       return "La persona fue eliminada correctamente";
   }
   
   
  
   
     @PutMapping("/persona/editar/{id}")
   
      public Persona editPersona(@PathVariable Long id,
                              @RequestParam ("nombre") String nuevoNombre,
                              @RequestParam ("apellido") String nuevoApellido,
                              @RequestParam ("sobremi") String nuevosobremi,
                              @RequestParam ("img_background") String nuevaImagenfondo,
                              @RequestParam ("fecNacimiento") String nuevaFecha,
                              @RequestParam ("mail") String nuevoEmail,
                              @RequestParam ("img_perfil") String nuevaImagenPerfil,
                              @RequestParam ("nacionalidad") String nuevaNacionalidad,
                              @RequestParam ("ocupacion") String nuevaOcupacion,
                              @RequestParam ("idDomicilio") Domicilio nuevoDomicilio
                              ){
       
       //buscamos la persona a modificar
       
       Persona pers = interPersona.buscarPersona(id);
       
       pers.setApellido(nuevoApellido);
       pers.setNombre(nuevoNombre);
       pers.setSobremi(nuevosobremi);
       pers.setImg_background(nuevaImagenfondo);
       pers.setFecNacimiento(nuevaFecha);
       pers.setMail(nuevoEmail);
       pers.setImg_perfil(nuevaImagenPerfil);
       pers.setNacionalidad(nuevaNacionalidad);
       pers.setOcupacion(nuevaOcupacion);
       pers.setIdDomicilio(nuevoDomicilio);  
       
       
       interPersona.savePersona(pers);
       return pers;
   }
   
   
      
      
      
      
      
      
      
}
