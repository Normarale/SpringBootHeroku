
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
@Table(name = "empleos")
public class Empleo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEmpleo;
    
    @Basic
     @Length(min=3, max=50)
     @NotEmpty
    private String tipo;
    
    

    public Empleo() {
    }

    public Empleo(Integer idEmpleo) {
      
        
        this.idEmpleo = idEmpleo.longValue();
        
    }
    
    public Empleo(Long id, String tipo) {
        this.idEmpleo = id;
        this.tipo = tipo;
    }
    
    
    
}
