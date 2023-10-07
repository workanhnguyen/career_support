package com.nva.server.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nva.server.pojos.Survey;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionForAdminDTO extends QuestionDTO {
    private Survey survey;
    private String listOptions;
}
