package com.example.community.web.dto;

import com.example.community.domain.Comment;
import com.example.community.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentListResponseDto {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    public CommentListResponseDto(Comment entity){
        this.id=entity.getId();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
        this.modifiedDate=entity.getModifiedDate();
    }
}
