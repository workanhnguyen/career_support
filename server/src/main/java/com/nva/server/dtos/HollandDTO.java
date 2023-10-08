package com.nva.server.dtos;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HollandDTO {
    private Long id;
    private String abbreviation;
    private String title;
    private String description;
    private String suitableCareer;
    private String image;
    private String strength;
    private String weakness;
}
