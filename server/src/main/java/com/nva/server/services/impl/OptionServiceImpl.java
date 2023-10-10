package com.nva.server.services.impl;

import com.nva.server.pojos.Option;
import com.nva.server.repositories.OptionRepository;
import com.nva.server.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionRepository optionRepository;
    @Override
    public void save(Option option) {
        optionRepository.save(option);
    }

    @Override
    public List<Option> findByQuestionId(Long questionId) {
        return optionRepository.findByQuestionId(questionId);
    }

    @Override
    public Optional<Option> findById(Long optionId) {
        return optionRepository.findById(optionId);
    }

    @Override
    public void deleteById(Long optionId) {
        optionRepository.deleteById(optionId);
    }
}
