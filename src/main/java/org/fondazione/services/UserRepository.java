package org.fondazione.services;

import org.fondazione.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByUsername(String username);

    List<User> findByUsernameAndVersion(String username, Integer version);

    Integer countByUsername(String username);
}
