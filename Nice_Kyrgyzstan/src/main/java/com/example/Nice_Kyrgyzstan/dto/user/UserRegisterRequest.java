package com.example.Nice_Kyrgyzstan.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRegisterRequest {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Boolean emailVerified;
    private String verificationCode;
    private Boolean banned;
    private String recoveryCode;


}
