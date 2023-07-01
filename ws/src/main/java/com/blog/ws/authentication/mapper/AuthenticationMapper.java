package com.blog.ws.authentication.mapper;

import com.blog.ws.authentication.mapper.dto.RegisterRequestDTO;
import com.blog.ws.member.entity.Member;

//TODO : Use mapstruct
public interface AuthenticationMapper {
    Member registerRequestDTOtoMember(RegisterRequestDTO dto);
}
