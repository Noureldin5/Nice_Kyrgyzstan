package com.example.Nice_Kyrgyzstan.service.auth;

import com.example.Nice_Kyrgyzstan.config.JwtService;
import com.example.Nice_Kyrgyzstan.dto.auth.*;
import com.example.Nice_Kyrgyzstan.entity.User;
import com.example.Nice_Kyrgyzstan.exception.CustomException;
import com.example.Nice_Kyrgyzstan.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository repository;
    @Autowired
    private AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .Token(jwtToken)
                .build();


    }



    @Override
    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .Token(jwtToken)
                .build();
    }

    @Override
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest) {
        Optional<User> user = repository.findByEmail(authLoginRequest.getEmail());
        if (user.isEmpty())
            throw new CustomException("User not found", HttpStatus.BAD_REQUEST);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authLoginRequest
                    .getEmail(),authLoginRequest.getPassword()));

        }catch (org.springframework.security.authentication.BadCredentialsException e){
            throw new CustomException("User not found", HttpStatus.BAD_REQUEST);
        }


        return convertToResponse(user);
    }

    public AuthLoginResponse convertToResponse(Optional<User> user) {
        AuthLoginResponse authLoginResponse = new AuthLoginResponse();
        authLoginResponse.setEmail(user.get().getEmail());


        Map<String, Object> extraClaims = new HashMap<>();
        String token = jwtService.generateToken(extraClaims, user.get());
        authLoginResponse.setToken(token);

        return authLoginResponse;
    }


}
