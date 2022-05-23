
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
@Table(name = "tecnologias") 
public class Tecnologia {
    
    @Id
   
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Basic
    @Length(min=3, max=50)
    @NotEmpty
    private String tecnologia;

    public Tecnologia() {
    }

    public Tecnologia(Integer id) {
      
        
        this.id = id.longValue();
        
    }
      
    public Tecnologia(Long id, String tecnologia) {
        this.id = id;
        this.tecnologia = tecnologia;
    }
    
    
    
}
