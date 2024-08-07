package com.example.Nice_Kyrgyzstan.controller;
import com.example.Nice_Kyrgyzstan.entity.EmailEntity;

import com.example.Nice_Kyrgyzstan.dto.EmailForm;
import com.example.Nice_Kyrgyzstan.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/email")
public class EmailController {
    @Autowired //why//
    private EmailService emailService;

    @GetMapping("/email")
    public ResponseEntity<List<EmailEntity>> getAllEmails() {
        List<EmailEntity> emails = emailService.getAllEmails();
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }//understand//


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
