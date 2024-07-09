package com.example.Nice_Kyrgyzstan.service;

import com.example.Nice_Kyrgyzstan.dto.EmailForm;
import com.example.Nice_Kyrgyzstan.entity.EmailEntity;
import com.example.Nice_Kyrgyzstan.repo.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private EmailRepository emailRepository;

    @Override
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
    @Override
    public void saveEmail(EmailForm emailForm) {
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setName(emailForm.getName());
        emailEntity.setSubject(emailForm.getSubject());
        emailEntity.setEmail(emailForm.getEmail());
        emailEntity.setMessage(emailForm.getMessage());

        emailRepository.save(emailEntity);
    }



}
