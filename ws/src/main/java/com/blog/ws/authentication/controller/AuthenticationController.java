package com.blog.ws.authentication.controller;

import com.blog.ws.authentication.entity.Token;
import com.blog.ws.authentication.mapper.dto.AuthenticationRequestDTO;
import com.blog.ws.authentication.mapper.dto.AuthenticationResponseDTO;
import com.blog.ws.authentication.mapper.dto.RegisterRequestDTO;
import com.blog.ws.authentication.repository.AuthenticationRepository;
import com.blog.ws.authentication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO requestDTO){
        return ResponseEntity.ok(authenticationService.register(requestDTO));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody AuthenticationRequestDTO requestDTO){
        return ResponseEntity.ok(authenticationService.authenticate(requestDTO));
    }

}
