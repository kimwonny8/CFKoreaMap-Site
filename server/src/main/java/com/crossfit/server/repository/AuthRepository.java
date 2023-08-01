package com.crossfit.server.repository;

import com.crossfit.server.entity.Authority;
import com.crossfit.server.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Authority, String> {

    Optional<Authority> findByAuthorityName(String role_coach);
}
