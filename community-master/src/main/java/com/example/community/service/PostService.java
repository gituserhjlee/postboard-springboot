package com.example.community.service;

import com.example.community.config.auth.dto.SessionUser;
import com.example.community.domain.Post;
import com.example.community.domain.PostRepository;
import com.example.community.domain.User;
import com.example.community.web.dto.PostListResponseDto;
import com.example.community.web.dto.PostResponseDto;
import com.example.community.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        Post post=Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .author(requestDto.getAuthor())
                .build();
        postRepository.save(post);
        return post.getId();
        //return postRepository.save(requestDto.toEntity()).getId();

    }

    public PostResponseDto findById(Long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다.id="+id));
        return new PostResponseDto(post);
    }
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc(){
        return postRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public Long update(Long id, PostSaveRequestDto requestDto) {
        Post post=postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다.id="+id));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
    @Transactional
    public void delete(Long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다.id="+id));
        postRepository.delete(post);
    }
}
