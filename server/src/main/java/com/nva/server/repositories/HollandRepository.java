package com.nva.server.repositories;

import com.nva.server.pojos.Holland;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HollandRepository extends JpaRepository<Holland, Long> {
}
