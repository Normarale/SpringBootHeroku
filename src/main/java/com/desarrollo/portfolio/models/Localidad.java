
package com.desarrollo.portfolio.models;




import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter @Setter
@Entity
@Table(name = "localidades") 

public class Localidad  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocalidad;
    
    @Basic
    @NotEmpty
    @Length(min=4, max=25)
    private String codigoPostal;
    
    @NotEmpty
    @Length(min=4, max=25)
    private String localidad;
    
   
     public Localidad() {
     
    }
    
     public Localidad(Integer idLocalidad) {
      
        
        this.idLocalidad = idLocalidad.longValue();
        
    }
    
     
    public Localidad(Long idLocalidad, String codigoPostal, String localidad) {
     
        this.idLocalidad = idLocalidad;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
    }

   

    

    
     
     
    
    

       
    
    
    
    
   
}
