package com.example.community.domain;

import com.example.community.web.dto.CommentListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> findByPostId(String postId);
}
