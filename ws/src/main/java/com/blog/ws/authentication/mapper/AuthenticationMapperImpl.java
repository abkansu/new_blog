package com.blog.ws.authentication.mapper;

import com.blog.ws.authentication.mapper.dto.RegisterRequestDTO;
import com.blog.ws.member.entity.Member;
import com.blog.ws.member.entity.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationMapperImpl implements AuthenticationMapper{

    private final PasswordEncoder passwordEncoder;

    @Override
    public Member registerRequestDTOtoMember(RegisterRequestDTO dto) {
        return Member
                .builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .password(passwordEncoder.encode(dto.getPassword()))
                .username(dto.getUsername())
                .role(Role.USER)
                .accountNonLocked(true)
                .accountNonExpired(true)
                .enabled(true)
                .build();
    }
}
