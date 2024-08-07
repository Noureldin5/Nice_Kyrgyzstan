package com.example.Nice_Kyrgyzstan.service.user;

import com.example.Nice_Kyrgyzstan.dto.user.UserRegisterRequest;
import com.example.Nice_Kyrgyzstan.dto.user.UserResponse;

public interface UserService {
    void register(UserRegisterRequest userRequest);

    void deleteById(Long id);

    UserResponse getById(Long id);

    void updateById(Long id, UserRegisterRequest userRequest);
}
