package com.example.Nice_Kyrgyzstan.service.user;

import com.example.Nice_Kyrgyzstan.dto.user.UserRegisterRequest;
import com.example.Nice_Kyrgyzstan.dto.user.UserResponse;
import com.example.Nice_Kyrgyzstan.entity.User;
import com.example.Nice_Kyrgyzstan.enums.Role;
import com.example.Nice_Kyrgyzstan.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository Repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRegisterRequest userRequest) {
        User user = User.builder()
                .firstname(userRequest.getFirstName())
                .lastname(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(Role.User)
                .build();

        Repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        User user = Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Repository.delete(user);

    }

    @Override
    public UserResponse getById(Long id ) {
        User user = Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));


        return null;
    }

    @Override
    public void updateById(Long id, UserRegisterRequest userRequest) {
        User user = Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstname(userRequest.getFirstName());
        user.setLastname(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        Repository.save(user);
    }




}
