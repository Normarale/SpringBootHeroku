
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Getter @Setter
@Entity
@Table(name = "personas")
public class Persona {
    
    @Id
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Basic  
    @Length(min=3, max=50)
    @NotEmpty
    private String nombre;
    
    @Length(min=3, max=50)
    @NotEmpty
    private String apellido;
    
    @Length(min=3, max=50)
    @NotEmpty
    private String fecNacimiento;
    
    @Length(min=3, max=50)
    @NotEmpty
    private String nacionalidad;
    
    @NotEmpty 
    @Email 
    private String mail;
    
    @Length(min=3, max=50)
    @NotEmpty
    private String sobremi;
    
    @Length(min=3, max=50)
    @NotNull
    private String ocupacion;
    
    @NotEmpty 
   // @URL
    private String img_perfil;
    
    @NotEmpty 
   // @URL
    private String img_background;
    
    
    @ManyToOne (cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name="domicilioid", referencedColumnName="idDomicilio", nullable = false, updatable=true)
    private Domicilio idDomicilio;
    
    


    public Persona() {
    }

    public Persona(Integer id) {
        this.id = id.longValue();
    }

    
    
    public Persona(Long id, String nombre, String apellido, String fecnacimiento, String nacionalidad, String mail, String sobremi, String ocupacion, String img_perfil, String img_background, Domicilio idDomicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNacimiento = fecnacimiento;
        this.nacionalidad = nacionalidad;
        this.mail = mail;
        this.sobremi = sobremi;
        this.ocupacion = ocupacion;
        this.img_perfil = img_perfil;
        this.img_background = img_background;
        this.idDomicilio = idDomicilio;
    }

    

   
      
    
    
}
