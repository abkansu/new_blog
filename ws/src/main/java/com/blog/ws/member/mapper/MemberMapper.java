package com.blog.ws.member.mapper;

import com.blog.ws.member.entity.Member;
import com.blog.ws.member.mapper.dto.MemberResponseDTO;
import org.springframework.stereotype.Component;


public interface MemberMapper {
    MemberResponseDTO memberToDTO(Member member);
}
