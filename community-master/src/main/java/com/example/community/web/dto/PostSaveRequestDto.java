package com.example.community.web.dto;

import com.example.community.domain.Post;
import com.example.community.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;


    @Builder
    public PostSaveRequestDto(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;

    }

}
