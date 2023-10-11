package com.nva.server.dtos;

import com.nva.server.pojos.Question;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDTO {
    private Long id;
    private String title;
    private String description;
    private String author;
    private String image;
    private Set<QuestionForClientDTO> questions;
}
