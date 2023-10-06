package com.nva.server.repositories;

import com.nva.server.pojos.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    @Query("SELECT s FROM Survey s WHERE LOWER(s.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Survey> findByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
