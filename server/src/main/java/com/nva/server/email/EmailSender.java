package com.nva.server.email;

public interface EmailSender {
    void send(String to, String email);
}
