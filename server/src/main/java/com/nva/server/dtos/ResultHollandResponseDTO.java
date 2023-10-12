package com.nva.server.dtos;

import com.nva.server.pojos.Holland;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultHollandResponseDTO {
    private Holland holland;
    private double percentage;
}
