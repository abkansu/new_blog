package com.blog.ws.member.mapper;

import com.blog.ws.member.entity.Member;
import com.blog.ws.member.mapper.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberMapperImpl implements MemberMapper{


    @Override
    public MemberResponseDTO memberToDTO(Member member) {
        return MemberResponseDTO
                .builder()
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .username(member.getUsername())
                .build();
    }
}
