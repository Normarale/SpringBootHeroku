
package com.desarrollo.portfolio.models;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private Integer id;
    @Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

    public Role() {
    }

    public Role(Integer id, ERole name) {
        this.id = id;
        this.name = name;
    }
	
    
    public Role(ERole name) {
		this.name = name;
	}
	
}
