package com.ejogajog.setup.service.setup.repository;

import java.util.Optional;

import com.ejogajog.setup.service.setup.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rakibul
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
	Boolean existsByEmail(String email);

}
