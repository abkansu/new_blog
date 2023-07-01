package com.blog.ws.member.mapper.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberResponseDTO {
    private String username;
    private String firstName;
    private String lastName;
}
