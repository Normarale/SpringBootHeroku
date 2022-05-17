
package com.desarrollo.portfolio.models;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "domicilios") 

public class Domicilio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idDomicilio;
    
    
    @Basic
    @Length(min=3, max=50)
    @NotEmpty
    private String direccion;
    
  
    
    @Length(min=1, max=50)
    @NotEmpty
    private String altura;
    
    
    
    @ManyToOne (cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "localidadId")
     private Localidad localidadId;
    
    

    public Domicilio() {
       
    }
    
    public Domicilio(Integer idDomicilio) {
      
        
        this.idDomicilio = idDomicilio.longValue();
        
    }

    public Domicilio(Long idDomicilio, String direccion, String altura, Localidad localidadId) {
        this.idDomicilio = idDomicilio;
        this.direccion = direccion;
        this.altura = altura;
        this.localidadId = localidadId;
    }

   

   
   
    
    



}