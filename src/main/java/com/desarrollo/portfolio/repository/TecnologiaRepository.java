
package com.desarrollo.portfolio.repository;

import com.desarrollo.portfolio.models.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long>{
    
    public void save(Long id);
}
