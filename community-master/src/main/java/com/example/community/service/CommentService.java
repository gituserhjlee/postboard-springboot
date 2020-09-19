package com.example.community.service;

import com.example.community.domain.Comment;
import com.example.community.domain.CommentRepository;
import com.example.community.domain.Post;
import com.example.community.domain.PostRepository;
import com.example.community.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Long save(CommentSaveRequestDto requestDto) {
        Comment comment= Comment.builder()
                .postId(requestDto.getPostId())
                .content(requestDto.getContent())
                .author(requestDto.getAuthor())
                .build();
        commentRepository.save(comment);
        return comment.getId();

    }

    public CommentResponseDto findById(Long id) {
        Comment comment=commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다.id="+id));
        return new CommentResponseDto(comment);
    }
//    @org.springframework.transaction.annotation.Transactional(readOnly = true)
//    public List<CommentListResponseDto> findAllDesc(){
//        return commentRepository.findByPostId().stream()
//                .map(CommentListResponseDto::new)
//                .collect(Collectors.toList());
//    }


    @Transactional
    public Long update(Long id, CommentSaveRequestDto requestDto) {
        Comment comment=commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다.id="+id));
        comment.update(requestDto.getContent());
        return id;
    }
    @Transactional
    public void delete(Long id) {
        Comment comment=commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다.id="+id));
        commentRepository.delete(comment);
    }
}
