
package com.desarrollo.portfolio.repository;

import com.desarrollo.portfolio.models.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
     public void save(Long id);
    }
