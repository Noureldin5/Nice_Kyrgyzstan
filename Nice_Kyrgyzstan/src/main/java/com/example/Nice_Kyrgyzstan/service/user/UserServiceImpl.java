package com.example.Nice_Kyrgyzstan.service.user;

import com.example.Nice_Kyrgyzstan.dto.user.UserRegisterRequest;
import com.example.Nice_Kyrgyzstan.dto.user.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public void register(UserRegisterRequest userRequest) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public UserResponse getById(Long id) {
        return null;
    }

    @Override
    public void updateById(Long id, UserRegisterRequest userRequest) {

    }
}
