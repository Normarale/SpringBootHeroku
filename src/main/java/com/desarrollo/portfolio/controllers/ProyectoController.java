
package com.desarrollo.portfolio.controllers;

import com.desarrollo.portfolio.models.Persona;
import com.desarrollo.portfolio.models.Proyecto;
import com.desarrollo.portfolio.services.IPersonaService;
import com.desarrollo.portfolio.services.IProyectoService;
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
public class ProyectoController {
    
    
    @Autowired 
    IProyectoService proServ;
    @Autowired
    IPersonaService perServ;
    
    
     @GetMapping("/proyecto/traer")
   public List<Proyecto> getProyecto(){
        return proServ.getProyecto();
   }
  
    
   
   @PostMapping("/proyecto/crear")
   public String CrearProyecto(@Valid @RequestBody Proyecto proy,  BindingResult resultado ){
       
       if (resultado.hasErrors()) {
          throw new InvalidDataException(resultado);
           }  else{ 
                    Persona per = perServ.buscarPersona(proy.getIdPersona().getId());
                    if (per != null){
                            proy.setIdPersona(per);
                   
                          proServ.saveProyecto(proy);
                        return "El proyecto fue creado exitosamente";
                   }else{
                        return " VER... Persona nula o inxesistente";
                    }
                } 
   }   
       
   
   
   @DeleteMapping("/proyecto/borrar/{id}")
   public String borrarProyecto (@PathVariable Long id){
       proServ.deleteProyecto(id);
       return "El proyecto fue elimindo correctamente";
   }
   
   
   @PutMapping("/proyecto/editar/{id}")
   
   public Proyecto editPersona(@PathVariable Long id,
                              @RequestParam ("proyectoDesc") String nuevoProyecto,
                              @RequestParam ("fotoUrl") String nuevaUrl,
                              @RequestParam("idPersona") Persona nuevaPersona
                              ){
       
       //buscamos la persona a modificar
       
       Proyecto proy = proServ.buscarProyecto(id);
       
       proy.setProyectoDesc(nuevoProyecto);
       proy.setFotoUrl(nuevaUrl);
       
       
       
       proServ.saveProyecto(proy);
       return proy;
   }
   
    
    
    
}
