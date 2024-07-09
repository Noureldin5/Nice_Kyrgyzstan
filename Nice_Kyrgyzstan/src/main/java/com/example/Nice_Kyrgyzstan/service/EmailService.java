package com.example.Nice_Kyrgyzstan.service;


import com.example.Nice_Kyrgyzstan.dto.EmailForm;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
    void saveEmail(EmailForm emailForm);


}
