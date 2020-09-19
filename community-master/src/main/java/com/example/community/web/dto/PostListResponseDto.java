package com.example.community.web.dto;

import com.example.community.config.auth.dto.SessionUser;
import com.example.community.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime modifiedDate;

    public PostListResponseDto(Post entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.author=entity.getAuthor();
        this.content=entity.getContent();
        this.modifiedDate=entity.getModifiedDate();
    }
}
