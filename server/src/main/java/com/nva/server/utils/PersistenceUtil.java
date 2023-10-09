package com.nva.server.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersistenceUtil {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public <T> T mergeEntity(T detachedEntity) {
        T managedEntity = entityManager.merge(detachedEntity);
        return managedEntity;
    }
}
