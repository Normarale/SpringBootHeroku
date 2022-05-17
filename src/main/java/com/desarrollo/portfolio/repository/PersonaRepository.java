
package com.desarrollo.portfolio.repository;

import com.desarrollo.portfolio.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {
public void save(Long id);
}
