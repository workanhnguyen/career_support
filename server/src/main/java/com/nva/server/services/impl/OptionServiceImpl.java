package com.nva.server.services.impl;

import com.nva.server.dtos.OptionForClientDTO;
import com.nva.server.dtos.QuestionForClientDTO;
import com.nva.server.pojos.Option;
import com.nva.server.pojos.Question;
import com.nva.server.repositories.OptionRepository;
import com.nva.server.services.OptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save(Option option) {
        optionRepository.save(option);
    }

    @Override
    public List<Option> findByQuestionId(Long questionId) {
        return optionRepository.findByQuestionId(questionId);
    }

    @Override
    public <T> List<T> convertToDTO(List<Option> options, Class<T> dtoClass) {
        if (dtoClass.isAssignableFrom(OptionForClientDTO.class)) {
            return options.stream().map(option -> modelMapper.map(option, dtoClass)).toList();
        }
        return (List<T>) options;
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
