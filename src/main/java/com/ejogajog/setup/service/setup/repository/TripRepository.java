package com.ejogajog.setup.service.setup.repository;


import com.ejogajog.setup.service.setup.domain.Trip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rakibul
 */
@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

}
