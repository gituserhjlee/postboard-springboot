package com.example.community.web;

import com.example.community.service.CommentService;
import com.example.community.web.dto.CommentResponseDto;
import com.example.community.web.dto.CommentSaveRequestDto;
import com.example.community.web.dto.PostResponseDto;
import com.example.community.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentApiController {
    private final CommentService commentService;


    @PostMapping("/api/v1/comment")
    public Long save(@RequestBody CommentSaveRequestDto requestDto){
        return commentService.save(requestDto);
    }

    @GetMapping("/api/v1/comment/{id}")
    public CommentResponseDto findById(@PathVariable Long id){
        return commentService.findById(id);
    }

    @PutMapping("/api/v1/comment/{id}")
    public Long update(@PathVariable Long id, @RequestBody CommentSaveRequestDto requestDto){
        return commentService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/comment/{id}")
    public Long delete(@PathVariable Long id){
        commentService.delete(id);
        return id;
    }
}