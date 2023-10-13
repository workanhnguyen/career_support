package com.nva.server.repositories;

import com.nva.server.pojos.ResponseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseDetailRepository extends JpaRepository<ResponseDetail, Long> {
    List<ResponseDetail> findByResponseId(Long responseId);
}
