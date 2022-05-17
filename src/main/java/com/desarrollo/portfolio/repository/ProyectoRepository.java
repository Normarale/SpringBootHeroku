
package com.desarrollo.portfolio.repository;

import com.desarrollo.portfolio.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    
    public void save(Long id);
}
