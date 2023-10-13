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
public class QuestionForClientDTO {
    private Long id;
    private String content;
    private Set<OptionForClientDTO> options;
}
