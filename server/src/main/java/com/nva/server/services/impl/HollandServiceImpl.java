package com.nva.server.services.impl;

import com.nva.server.dtos.HollandDTO;
import com.nva.server.pojos.Holland;
import com.nva.server.repositories.HollandRepository;
import com.nva.server.services.HollandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HollandServiceImpl implements HollandService {
    @Autowired
    private HollandRepository hollandRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Holland> findAll() {
        return hollandRepository.findAll();
    }

    @Override
    public List<HollandDTO> convertToDTO(List<Holland> hollands) {
        List<HollandDTO> hollandDTOs = new ArrayList<>();

        hollands.forEach(h -> hollandDTOs.add(modelMapper.map(h, HollandDTO.class)));
        return hollandDTOs;
    }
}
