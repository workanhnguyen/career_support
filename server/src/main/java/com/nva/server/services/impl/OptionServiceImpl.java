package com.nva.server.services.impl;

import com.nva.server.pojos.Option;
import com.nva.server.repositories.OptionRepository;
import com.nva.server.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionRepository optionRepository;
    @Override
    public void save(Option option) {
        optionRepository.save(option);
    }
}
