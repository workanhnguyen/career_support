package com.nva.server.repositories;

import com.nva.server.pojos.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findByUserId(Long userId);
    List<Response> findByCreatedAtBetween(Date startDate, Date endDate);
}
