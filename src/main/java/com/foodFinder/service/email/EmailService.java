package com.foodFinder.service.email;

import java.io.IOException;

public interface EmailService {
    public void sendHTML(String from, String to, String subject, String body) throws IOException;
    public void sendText(String from, String to, String subject, String body) throws IOException;
}
