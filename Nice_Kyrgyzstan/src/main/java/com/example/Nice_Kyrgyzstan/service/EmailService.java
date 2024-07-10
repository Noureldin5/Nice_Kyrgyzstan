package com.example.Nice_Kyrgyzstan.service;


import com.example.Nice_Kyrgyzstan.dto.EmailForm;
import com.example.Nice_Kyrgyzstan.entity.Email;

import java.util.List;

public interface EmailService {
    void sendEmail(String to, String subject, String text);

    void saveEmailForm(EmailForm emailForm);
    List<Email> getAllEmails();}
