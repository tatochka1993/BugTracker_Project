package org.tatsiana.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tatsiana.webapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
