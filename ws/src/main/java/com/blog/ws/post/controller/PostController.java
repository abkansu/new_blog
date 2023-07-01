package com.blog.ws.post.controller;

import com.blog.ws.post.mapper.dto.PostRequestDTO;
import com.blog.ws.post.mapper.dto.PostResponseDTO;
import com.blog.ws.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public PostResponseDTO getPost(@RequestParam UUID uuid){
        return postService.getPost(uuid);
    }

    @PostMapping("/post")
    public HttpStatus saveOrUpdatePost(@RequestBody PostRequestDTO postRequestDTO){
        return postService.saveOrUpdatePost(postRequestDTO);
    }

    @DeleteMapping("/delete")
    public HttpStatus deletePost(@RequestParam UUID uuid){
        return postService.deletePost(uuid);
    }
}
