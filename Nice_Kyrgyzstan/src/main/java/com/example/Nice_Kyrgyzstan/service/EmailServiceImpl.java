package com.example.Nice_Kyrgyzstan.service;

import com.example.Nice_Kyrgyzstan.dto.EmailForm;
import com.example.Nice_Kyrgyzstan.entity.Email;
import com.example.Nice_Kyrgyzstan.repo.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void saveEmailForm(EmailForm emailForm) {
        Email emailEntity = new Email();
        emailEntity.setName(emailForm.getName());
        emailEntity.setSubject(emailForm.getSubject());
        emailEntity.setEmail(emailForm.getEmail());
        emailEntity.setMessage(emailForm.getMessage());

        emailRepository.save(emailEntity);
    }

    @Override
    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }


}
