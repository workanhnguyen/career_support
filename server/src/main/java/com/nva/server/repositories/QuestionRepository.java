package com.nva.server.repositories;

import com.nva.server.pojos.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySurveyId(Long surveyId);
    Optional<Question> findById(Long questionId);
}
