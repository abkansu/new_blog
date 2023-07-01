package com.blog.ws.member.controller;

import com.blog.ws.member.mapper.dto.MemberRequestDTO;
import com.blog.ws.member.mapper.dto.MemberResponseDTO;
import com.blog.ws.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    /*
    @PostMapping("/post")
    public HttpStatus saveOrUpdateMember(@RequestBody MemberRequestDTO memberRequestDTO){
        return memberService.saveOrUpdateMember(memberRequestDTO);
    }*/

    @GetMapping("/get")
    public MemberResponseDTO getMember(@RequestParam String username){
        return memberService.getMember(username);
    }

    @DeleteMapping("/delete")
    public HttpStatus deleteMember(@RequestParam UUID uuid){
        return memberService.deleteMember(uuid);
    }
}
