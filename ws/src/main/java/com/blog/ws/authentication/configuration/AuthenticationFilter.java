package com.blog.ws.authentication.configuration;

import com.blog.ws.authentication.entity.Token;
import com.blog.ws.authentication.service.AuthenticationService;
import com.blog.ws.authentication.service.helper.AuthenticationServiceHelper;
import com.blog.ws.member.service.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.blog.ws.authentication.service.helper.AuthenticationServiceHelper.*;

@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

    private final MemberService memberService;
    private final AuthenticationServiceHelper authenticationServiceHelper;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        if((authHeader == null) || !authHeader.startsWith("Bearer ")) {filterChain.doFilter(request, response); return;}
        Token token = authenticationServiceHelper.getToken(extractToken(authHeader));
        String userName = extractUsername(token.getToken());
        UserDetails userDetails = memberService.loadUserByUsername(userName);
        if(userName == null || SecurityContextHolder.getContext().getAuthentication() != null){ filterChain.doFilter(request, response); return; }
        if(!isTokenValid(token, userDetails)){ filterChain.doFilter(request, response); return; }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
        authenticationToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
