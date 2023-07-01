package com.blog.ws.authentication.service;

import com.blog.ws.authentication.entity.Token;
import com.blog.ws.authentication.exception.TokenNotFoundException;
import com.blog.ws.authentication.mapper.AuthenticationMapper;
import com.blog.ws.authentication.mapper.dto.AuthenticationRequestDTO;
import com.blog.ws.authentication.mapper.dto.AuthenticationResponseDTO;
import com.blog.ws.authentication.mapper.dto.RegisterRequestDTO;
import com.blog.ws.authentication.repository.AuthenticationRepository;
import com.blog.ws.member.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.stereotype.Service;

import static com.blog.ws.authentication.service.helper.AuthenticationServiceHelper.*;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final MemberService memberService;
    private final AuthenticationMapper authenticationMapper;
    private final AuthenticationRepository authenticationRepository;
    private final AuthenticationManager authenticationManager;


    @Transactional
    public AuthenticationResponseDTO register(RegisterRequestDTO requestDTO) {
        var member = authenticationMapper.registerRequestDTOtoMember(requestDTO);
        memberService.saveOrUpdateMember(member);
        var token = Token.builder().token(generateToken(member)).isUsable(true).build();
        authenticationRepository.save(token);
        return AuthenticationResponseDTO.builder().token(token.getToken()).build();
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO requestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDTO.getUsername(),
                        requestDTO.getPassword()
                )
        );
        var member = memberService.loadUserByUsername(requestDTO.getUsername());
        var token = Token.builder().token(generateToken(member)).isUsable(true).build();
        authenticationRepository.save(token);
        return AuthenticationResponseDTO.builder().token(token.getToken()).build();
    }


}
