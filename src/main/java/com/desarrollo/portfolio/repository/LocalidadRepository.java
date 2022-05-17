
package com.desarrollo.portfolio.repository;

import com.desarrollo.portfolio.models.Localidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long> {
    
public void save(Long id);

}
