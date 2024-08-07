package com.example.Nice_Kyrgyzstan.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthLoginResponse {
    private Long id;
    private String email;
    private String nickName;
    private String token;
}
