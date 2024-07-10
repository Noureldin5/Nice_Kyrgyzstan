package com.example.Nice_Kyrgyzstan.controller;
import com.example.Nice_Kyrgyzstan.entity.Email;

import com.example.Nice_Kyrgyzstan.dto.EmailForm;
import com.example.Nice_Kyrgyzstan.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/email")
    public ResponseEntity<List<Email>> getAllEmails() {
        List<Email> emails = emailService.getAllEmails();
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }


    @PostMapping("/email")
    public ResponseEntity<?> submitEmailForm(@Valid @RequestBody EmailForm emailForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        emailService.saveEmailForm(emailForm);

        emailService.sendEmail(emailForm.getEmail(), "Thank you for contacting us",
                "Dear " + emailForm.getName() + ",\n\nThank you for reaching out. We will contact you as soon as possible.\n\nBest regards,\nYour Company");

        return ResponseEntity.status(HttpStatus.OK).body("Your message has been sent successfully!");
    }

}
