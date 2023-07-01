package com.blog.ws.member.service;

import com.blog.ws.member.entity.Member;
import com.blog.ws.member.mapper.MemberMapper;
import com.blog.ws.member.mapper.dto.MemberRequestDTO;
import com.blog.ws.member.mapper.dto.MemberResponseDTO;
import com.blog.ws.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findMemberByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
    }

    @Transactional
    public HttpStatus saveOrUpdateMember(Member member) {
        var memberVt = memberRepository.findMemberByUsername(member.getUsername());
        if(memberVt.isPresent()){return updateMember(member, memberVt.get());}
        else {memberRepository.save(member);}
        return HttpStatus.OK;
    }

    private HttpStatus updateMember(Member member, Member memberVt) {
        memberVt.setFirstName(member.getFirstName());
        memberVt.setLastName(member.getLastName());
        memberVt.setUsername(member.getUsername());
        memberVt.setPassword(member.getPassword());
        memberVt.setEnabled(member.isEnabled());
        memberVt.setAccountNonExpired(member.isAccountNonExpired());
        memberVt.setAccountNonLocked(member.isAccountNonLocked());
        memberRepository.save(memberVt);
        return HttpStatus.OK;
    }

    public MemberResponseDTO getMember(String username) {
        return memberMapper.memberToDTO(memberRepository.findMemberByUsername(username).get());
    }


    public HttpStatus deleteMember(UUID uuid) {
        return HttpStatus.ACCEPTED;
    }

}
