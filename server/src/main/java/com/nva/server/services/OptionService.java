package com.nva.server.services;

import com.nva.server.pojos.Option;
import com.nva.server.pojos.Question;

import java.util.List;
import java.util.Optional;

public interface OptionService {
    void save(Option option);
    List<Option> findByQuestionId(Long questionId);
    <T> List<T> convertToDTO(List<Option> options, Class<T> dtoClass);
    Optional<Option> findById(Long optionId);
    void deleteById(Long optionId);
}
