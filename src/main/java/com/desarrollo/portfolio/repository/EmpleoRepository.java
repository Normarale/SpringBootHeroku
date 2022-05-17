
package com.desarrollo.portfolio.repository;

import com.desarrollo.portfolio.models.Empleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleoRepository  extends JpaRepository<Empleo, Long>{
    public void save(Long id);
}
