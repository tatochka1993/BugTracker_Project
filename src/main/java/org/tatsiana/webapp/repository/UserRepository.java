package org.tatsiana.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tatsiana.webapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

}
