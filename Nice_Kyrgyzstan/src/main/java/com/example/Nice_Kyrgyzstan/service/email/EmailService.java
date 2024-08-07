package com.example.Nice_Kyrgyzstan.service.email;


import com.example.Nice_Kyrgyzstan.dto.EmailForm;
import com.example.Nice_Kyrgyzstan.entity.EmailEntity;

import java.util.List;

public interface EmailService {
    void sendEmail(String to, String subject, String text);

    void saveEmailForm(EmailForm emailForm);
    List<EmailEntity> getAllEmails();}
