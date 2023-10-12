package com.nva.server.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseSurveyHollandFromClientDTO {
    private Long userId;
    private Long surveyId;
    private Set<QuestionResponseDTO> questions;
}
