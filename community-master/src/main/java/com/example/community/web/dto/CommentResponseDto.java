package com.example.community.web.dto;

import com.example.community.domain.Comment;

public class CommentResponseDto {
    private Long id;
    private String postId;
    private String content;
    private String author;


    public CommentResponseDto(Comment entity){
        this.id=entity.getId();
        this.postId=entity.getPostId();
        this.content=entity.getContent();
        this.author=entity.getAuthor();

    }
}