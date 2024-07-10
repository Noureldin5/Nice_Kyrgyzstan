package com.example.Nice_Kyrgyzstan.repo;

import com.example.Nice_Kyrgyzstan.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository <Email, Long> {
}
