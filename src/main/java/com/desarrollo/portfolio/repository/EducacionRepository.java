
package com.desarrollo.portfolio.repository;

import com.desarrollo.portfolio.models.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository <Educacion, Long>{
    public void save(Long id);
}
