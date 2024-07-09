package com.example.Nice_Kyrgyzstan.controller;

import com.example.Nice_Kyrgyzstan.dto.EmailForm;
import com.example.Nice_Kyrgyzstan.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/email")
    public String showEmailForm(Model model) {
        model.addAttribute("emailForm", new EmailForm());
        return "email";
    }

    @PostMapping("/email")
    public String submitEmailForm(@Valid EmailForm emailForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "email";
        }

        emailService.sendEmail(emailForm.getEmail(), "Thank you for contacting us",
                "Dear " + emailForm.getName() + ",\n\nThank you for reaching out. We will contact you as soon as possible.\n\nBest regards,\nYour Company");

        model.addAttribute("successMessage", "Your message has been sent successfully!");
        return "email";
    }

}
