package com.nva.server.dtos;

import com.nva.server.pojos.Survey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionForAdminDTO extends QuestionDTO {
    private Survey survey;
    private String listOptions;
}
