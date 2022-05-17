
package com.desarrollo.portfolio.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
@Entity
@Table(name = "experiencias")
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
    
    @Basic
    @Length(min=3, max=50)
    @NotEmpty
    private String nombreEmpresa;
    
    @Length(min=3, max=50)
    @NotEmpty
    private String trabajoActual;
    
    @Length(min=4, max=50)
    @NotEmpty
    private String fecInicio;
    
    @Length(min=4, max=50)
    @NotEmpty
    private String fecFinal;
    
    @Length(min=3, max=50)
    @NotEmpty
    private String descripcion;
    
       
    @ManyToOne
    @NotNull
    @JoinColumn(name="idPersona")
    private Persona personaId;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name="idEmpleo")
    private Empleo empleoId;

    
    public Experiencia() {
    }

    public Experiencia(Integer id) {
      
        
        this.id = id.longValue();
        
    }
    
    public Experiencia(Long id, String nombreEmpresa, String trabajoActual, String fecInicio, String fecFinal, String descripcion, Persona personaId, Empleo empleoId) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.trabajoActual = trabajoActual;
        this.fecInicio = fecInicio;
        this.fecFinal = fecFinal;
        this.descripcion = descripcion;
        this.personaId = personaId;
        this.empleoId = empleoId;
    }

   
   
    

   
    
    
    
}
