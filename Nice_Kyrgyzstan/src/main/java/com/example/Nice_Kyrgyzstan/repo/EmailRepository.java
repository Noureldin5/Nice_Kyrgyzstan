package com.example.Nice_Kyrgyzstan.repo;

import com.example.Nice_Kyrgyzstan.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository <EmailEntity, Long> {
}
