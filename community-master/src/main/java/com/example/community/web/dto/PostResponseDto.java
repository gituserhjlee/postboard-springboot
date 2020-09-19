package com.example.community.web.dto;

import com.example.community.config.auth.dto.SessionUser;
import com.example.community.domain.Post;
import com.example.community.domain.User;

import javax.mail.Session;

public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;


    public PostResponseDto(Post entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();

    }
}
