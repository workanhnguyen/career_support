package com.nva.server.services;

import com.nva.server.pojos.Option;

import java.util.List;
import java.util.Optional;

public interface OptionService {
    void save(Option option);
    List<Option> findByQuestionId(Long questionId);
    Optional<Option> findById(Long optionId);
}
