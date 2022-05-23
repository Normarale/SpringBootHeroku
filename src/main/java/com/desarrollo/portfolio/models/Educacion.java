
package com.desarrollo.portfolio.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Getter @Setter
@Entity
@Table(name = "estudios") 
public class Educacion {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long id;
 
    @Basic
     
    @Length(min=2, max=50)
    @NotEmpty
    private String institucion;
    
    @Length(min=3, max=50)
    @NotEmpty
    private String titulo;
    
    @Length(min=3, max=50)
    @NotEmpty
    private String carrera;
    
    @URL
    private String imagen;
    
    @Length(min=1, max=3)
    @NotEmpty
    private String puntaje;
    
    @NotBlank
    private String fechaDesde;
    
    @NotBlank
    private String fechaHasta;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "educacion_has_personas", 
				joinColumns = @JoinColumn(name = "educacion_id"), 
				inverseJoinColumns = @JoinColumn(name = "persona_id"))
	private Set<Persona> persona;
    
    

    public Educacion() {
     }
    
    
    public Educacion(Integer id) {
      
        
        this.id = id.longValue();
        
    }
    
    public Educacion(Long id, String institucion, String titulo, String carrera, String imagen, String puntaje, String fechaDesde, String fechaHasta) {
        this.persona = new HashSet<>();
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
        this.carrera = carrera;
        this.imagen = imagen;
        this.puntaje = puntaje;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }
   
    
    
}