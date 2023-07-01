package com.blog.ws.post.service;

import com.blog.ws.post.mapper.dto.PostRequestDTO;
import com.blog.ws.post.mapper.dto.PostResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {
    public PostResponseDTO getPost(UUID uuid) {
        return null;
    }

    public HttpStatus saveOrUpdatePost(PostRequestDTO postRequestDTO) {
        return HttpStatus.CREATED;

        /*
        TODO: CHECK IF EXISTS
        if(){HttpStatus.OK}
        else{return HttpStatus.CREATED};
        */
    }

    public HttpStatus deletePost(UUID uuid) {

        return HttpStatus.ACCEPTED;
    }
}
