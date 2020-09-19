package com.example.community.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {
    private String postId;
    private String content;
    private String author;


    @Builder
    public CommentSaveRequestDto(String postId, String content, String author){
        this.postId=postId;
        this.content=content;
        this.author=author;

    }

}