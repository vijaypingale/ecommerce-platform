package com.javaworld.user_service.repository;

import com.javaworld.user_service.models.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {
}
