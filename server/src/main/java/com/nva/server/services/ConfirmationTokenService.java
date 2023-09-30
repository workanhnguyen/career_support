package com.nva.server.services;

import com.nva.server.pojos.ConfirmationToken;

import java.util.Optional;

public interface ConfirmationTokenService {
    void saveConfirmationToken(ConfirmationToken token);
    Optional<ConfirmationToken> findByToken(String token);
    int setConfirmedAt(String token);
    boolean deleteConfirmationTokenByUserId(Long userId);
}
