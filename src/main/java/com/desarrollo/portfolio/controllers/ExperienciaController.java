
package com.desarrollo.portfolio.controllers;

import com.desarrollo.portfolio.models.Empleo;
import com.desarrollo.portfolio.models.Experiencia;
import com.desarrollo.portfolio.models.Persona;
import com.desarrollo.portfolio.services.IEmpleoService;
import com.desarrollo.portfolio.services.IExperienciaService;
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
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expServ;
    @Autowired 
    private IPersonaService perServ;
    @Autowired
    private IEmpleoService empServ;
    
    @GetMapping("/experiencia/traer")
   public List<Experiencia> getExperiencia(){
        return expServ.getExperiencia();
   }
    
   
    @PostMapping("/experiencia/crear")
   public String CrearExperiencia(@Valid @RequestBody Experiencia exp, BindingResult resultado){
       
        if (resultado.hasErrors()) {
            throw new InvalidDataException(resultado);
             }  else{   
                      Persona per = perServ.buscarPersona(exp.getPersonaId().getId());
                      Empleo emp = empServ.buscarEmpleo(exp.getEmpleoId().getIdEmpleo());
                    if (per != null && emp != null ){
                           exp.setPersonaId(per);
                           exp.setEmpleoId(emp);
                          expServ.saveExperiencia(exp);
                        return "la Experiencia fue creada exitosamente";
                        } else{
                        return "VER... Persona o Empleo Nulo o  Inexistente";
                    }
                    
        }
   }
   
    @DeleteMapping("/experiencia/borrar/{id}")
   public String borrarExperiencia (@PathVariable Long id){
       expServ.deleteExperiencia(id);
       return "La experiencia fue borrada correctamente";
   }
   
   @PutMapping("/experiencia/editar/{id}")
                           

   public Experiencia editExperiencia(@PathVariable Long id,
                              @RequestParam ("nombreEmpresa") String nuevoNombre,
                              @RequestParam ("trabajoActual") String nuevoTrabajo,
                              @RequestParam ("fecInicio") String nuevaFecha,
                              @RequestParam ("fecFinal") String nuevaFechaFin,
                              @RequestParam ("descripcion") String nuevaDescripcion,
                              @RequestParam ("idPersona") Persona nuevaIdPersona,
                              @RequestParam ("idEmpleo") Empleo nuevoIdTipo
                              ){
       
       //buscamos la experiencoia a modificar
       
       Experiencia exp = expServ.buscarExperiencia(id);
       
       exp.setNombreEmpresa(nuevoNombre);
       exp.setTrabajoActual(nuevoTrabajo);
       exp.setFecInicio(nuevaFecha);
       exp.setFecFinal(nuevaFechaFin);
       exp.setDescripcion(nuevaDescripcion);
       exp.setPersonaId(nuevaIdPersona);
       exp.setEmpleoId(nuevoIdTipo);
       
       expServ.saveExperiencia(exp);
       return exp;
   }
   
}
