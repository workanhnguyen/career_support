package com.nva.server.services.impl;

import com.nva.server.pojos.ResponseDetail;
import com.nva.server.repositories.ResponseDetailRepository;
import com.nva.server.services.ResponseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseDetailServiceImpl implements ResponseDetailService {
    @Autowired
    private ResponseDetailRepository responseDetailRepository;
    @Override
    public void save(ResponseDetail responseDetail) {
        responseDetailRepository.save(responseDetail);
    }
}
