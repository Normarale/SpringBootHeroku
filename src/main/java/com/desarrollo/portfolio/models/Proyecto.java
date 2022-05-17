
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Getter @Setter
@Entity
@Table(name = "proyectos") 
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Basic
    @Length(min=3, max=50)
    @NotEmpty
    private String proyectoDesc;
    
    
    @Length(min=3, max=50)
    @NotEmpty
    @URL
    private String fotoUrl;
    
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "idPersona")
    private Persona idPersona;

    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "proyectos_has_tecnologias", 
				joinColumns = @JoinColumn(name = "proyecto_id"), 
				inverseJoinColumns = @JoinColumn(name = "tenologia_id"))
	private Set<Tecnologia> tecno = new HashSet<>();
    
    
    
    
    
    public Proyecto() {
    }

    public Proyecto(Integer id) {
              
        this.id = id.longValue();
        
    }
    
    
    public Proyecto(Long id, String proyectoDesc, String fotoUrl, Persona idpersona) {
        this.id = id;
        this.proyectoDesc = proyectoDesc;
        this.fotoUrl = fotoUrl;
        this.idPersona = idpersona;
    }
    
    
    
}
