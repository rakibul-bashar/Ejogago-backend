package com.ejogajog.setup.service.setup.repository;

import com.ejogajog.setup.service.constant.RoleType;
import com.ejogajog.setup.service.setup.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rakibul
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleType name);
}
