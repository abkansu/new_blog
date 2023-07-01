package com.blog.ws.authentication.repository;

import com.blog.ws.authentication.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationRepository extends JpaRepository<Token, Long> {
    Optional<Token> findTokenByToken(String token);
}
