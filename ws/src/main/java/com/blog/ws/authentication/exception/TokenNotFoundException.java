package com.blog.ws.authentication.exception;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class TokenNotFoundException extends Exception {
    private final String message;
}
