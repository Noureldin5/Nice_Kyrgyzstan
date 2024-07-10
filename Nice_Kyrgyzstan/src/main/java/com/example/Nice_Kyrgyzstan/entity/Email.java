package com.example.Nice_Kyrgyzstan.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "emails")
    public class Email {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        private String name;

        @NotBlank(message = "Subject is required")
        @Size(min = 2, max = 100, message = "Subject must be between 2 and 100 characters")
        private String subject;

        @NotBlank(message = "Email is required")
        @jakarta.validation.constraints.Email(message = "Email should be valid")
        private String email;

        @NotBlank(message = "Message is required")
        @Size(min = 10, max = 500, message = "Message must be between 10 and 500 characters")
        private String message;
}
