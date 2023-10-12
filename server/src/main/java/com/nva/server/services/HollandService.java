package com.nva.server.services;

import com.nva.server.dtos.HollandDTO;
import com.nva.server.pojos.Holland;

import java.util.List;
import java.util.Optional;

public interface HollandService {
    List<Holland> findAll();
    List<HollandDTO> convertToDTO(List<Holland> hollands);
    Optional<Holland> findById(Long hollandId);
}
