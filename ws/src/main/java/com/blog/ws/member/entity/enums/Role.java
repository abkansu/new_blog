package com.blog.ws.member.entity.enums;

public enum Role {
    USER,
    ADMIN;

    public String getRole(){
        return "ROLE_" + this.name();
    }
}
