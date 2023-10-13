package com.nva.server.repositories;

import com.nva.server.pojos.ResponseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseDetailRepository extends JpaRepository<ResponseDetail, Long> {
}
