package com.nva.server.services;

import com.nva.server.pojos.Option;

import java.util.List;

public interface OptionService {
    void save(Option option);
    List<Option> findByQuestionId(Long questionId);
}
