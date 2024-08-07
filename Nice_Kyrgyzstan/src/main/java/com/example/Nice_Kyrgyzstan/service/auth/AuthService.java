package com.example.Nice_Kyrgyzstan.service.auth;

import com.example.Nice_Kyrgyzstan.dto.auth.*;
import com.example.Nice_Kyrgyzstan.dto.user.UserRegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);


    AuthResponse authenticate(AuthRequest request);

    AuthLoginResponse login(AuthLoginRequest authLoginRequest);
}
