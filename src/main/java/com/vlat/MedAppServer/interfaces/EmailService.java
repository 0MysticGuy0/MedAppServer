package com.vlat.MedAppServer.interfaces;

import jakarta.mail.MessagingException;

public interface EmailService {
     void sendSimpleEmail(String toAddress, String subject, String message);
}
