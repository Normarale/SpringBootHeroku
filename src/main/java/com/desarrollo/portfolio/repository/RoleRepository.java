
package com.desarrollo.portfolio.repository;

import com.desarrollo.portfolio.models.ERole;
import com.desarrollo.portfolio.models.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
