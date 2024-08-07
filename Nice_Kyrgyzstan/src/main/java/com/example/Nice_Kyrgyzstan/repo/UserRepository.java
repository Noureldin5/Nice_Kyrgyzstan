package com.example.Nice_Kyrgyzstan.repo;

import com.example.Nice_Kyrgyzstan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

}
