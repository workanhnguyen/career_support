package com.nva.server.services.impl;

import com.nva.server.pojos.Holland;
import com.nva.server.repositories.HollandRepository;
import com.nva.server.services.HollandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HollandServiceImpl implements HollandService {
    @Autowired
    private HollandRepository hollandRepository;
    @Override
    public List<Holland> findAll() {
        return hollandRepository.findAll();
    }
}
