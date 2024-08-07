package com.example.Nice_Kyrgyzstan.service.user;

import com.example.Nice_Kyrgyzstan.dto.user.UserRegisterRequest;
import com.example.Nice_Kyrgyzstan.dto.user.UserResponse;
import com.example.Nice_Kyrgyzstan.entity.User;
import com.example.Nice_Kyrgyzstan.enums.Role;
import com.example.Nice_Kyrgyzstan.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testRegister() {
        // Given
        UserRegisterRequest userRequest = new UserRegisterRequest("John", "Doe", "john@example.com", "password");
        when(passwordEncoder.encode(userRequest.getPassword())).thenReturn("encodedPassword");

        // When
        userService.register(userRequest);

        // Then
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testDeleteById() {
        // Given
        Long userId = 1L;
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // When
        userService.deleteById(userId);

        // Then
        verify(userRepository, times(1)).delete(user);
    }

    @Test
    public void testGetById() {
        // Given
        Long userId = 1L;
        User user = new User(1, "John", "Doe", "john@example.com", "password", Role.User);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // When
        UserResponse userResponse = userService.getById(userId);

        // Then
        assertNotNull(userResponse);
        assertEquals("John", userResponse.getFirstName());
        assertEquals("Doe", userResponse.getLastName());
        assertEquals("john@example.com", userResponse.getEmail());
    }

    @Test
    public void testUpdateById() {
        // Given
        Long userId = 1L;
        User user = new User();
        UserRegisterRequest userRequest = new UserRegisterRequest("John", "Doe", "john@example.com", "password");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // When
        userService.updateById(userId, userRequest);

        // Then
        verify(userRepository, times(1)).save(any(User.class));
    }
}
