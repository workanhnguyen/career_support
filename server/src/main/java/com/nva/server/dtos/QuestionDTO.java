package com.nva.server.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nva.server.pojos.Survey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDTO {
    private Long id;
    private String content;
    private Date createdAt;
    private Date updatedAt;
}