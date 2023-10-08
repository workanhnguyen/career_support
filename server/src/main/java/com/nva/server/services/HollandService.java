package com.nva.server.services;

import com.nva.server.dtos.HollandDTO;
import com.nva.server.pojos.Holland;

import java.util.List;

public interface HollandService {
    List<Holland> findAll();
    List<HollandDTO> convertToDTO(List<Holland> hollands);
}
