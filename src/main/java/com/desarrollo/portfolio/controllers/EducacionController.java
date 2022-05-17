
package com.desarrollo.portfolio.controllers;

import com.desarrollo.portfolio.models.Educacion;
import com.desarrollo.portfolio.services.IEducacionService;
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
public class EducacionController {
    
     @Autowired
    private IEducacionService eduServ;
    
   @GetMapping("/educacion/traer")
   public List<Educacion> getEducacion(){
        return eduServ.getEducacion();
   }
  
    
   
   @PostMapping("/educacion/crear")
   public String CrearEducacion(@Valid @RequestBody Educacion edu, BindingResult resultado){
        if (resultado.hasErrors()) {
            throw new InvalidDataException(resultado);
             }  else{         
                    eduServ.saveEducacion(edu);
                    return "La educacion fue creada exitosamente";
                }    
   }
   
   
   @DeleteMapping("/educacion/borrar/{id}")
   public String borrarEducacion (@PathVariable Long id){
       eduServ.deleteEducacion(id);
       return "La educacion fue eliminda correctamente";
   }
   
   
   @PutMapping("/educacion/editar/{id}")
   
   public Educacion editPersona(@PathVariable Long id,
                              @RequestParam ("institucion") String nuevaInstitucion,
                              @RequestParam ("titulo") String nuevoTitulo,
                              @RequestParam ("carrera") String nuevaCarrera,
                              @RequestParam ("imagen") String nuevaImagen,
                              @RequestParam ("puntaje") String nuevoPuntaje,
                              @RequestParam ("fechaDesde") String nuevaFechaDesde,
                              @RequestParam ("fechaHasta") String nuevaFechaHasta
                             ){
       
       //buscamos la educacion a modificar
       
       Educacion edu = eduServ.buscarEducacion(id);
       
      edu.setInstitucion(nuevaInstitucion);
      edu.setTitulo(nuevoTitulo);
      edu.setCarrera(nuevaCarrera);
      edu.setImagen(nuevaImagen);
      edu.setPuntaje(nuevoPuntaje);
      edu.setFechaDesde(nuevaFechaDesde);
      edu.setFechaHasta(nuevaFechaHasta);
       
       
       eduServ.saveEducacion(edu);
       return edu;
   }
    
}
