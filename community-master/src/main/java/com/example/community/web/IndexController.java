package com.example.community.web;

import com.example.community.config.auth.LoginUser;
import com.example.community.config.auth.dto.SessionUser;
import com.example.community.domain.CommentRepository;
import com.example.community.service.CommentService;
import com.example.community.service.PostService;
import com.example.community.web.dto.CommentListResponseDto;
import com.example.community.web.dto.CommentResponseDto;
import com.example.community.web.dto.PostListResponseDto;
import com.example.community.web.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostService postService;
    private final CommentService commentService;
    private final CommentRepository commentRepository;


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("post", postService.findAllDesc());
        if(user !=null){
            model.addAttribute("userName", user.getEmail());
        }
        return "index";
    }
    @GetMapping("/comment/see/{id}")  //각 포스트에 해당하는 댓글목록만 넘겨줘야함. post의 아이디를 댓글이 가지고 있어야함
    public String seeComment(Model model, @PathVariable String id){
        model.addAttribute("comment",commentRepository.findByPostId(id).stream()
                .map(CommentListResponseDto::new)
                .collect(Collectors.toList()));

        return "seecomment";
    }
    @GetMapping("/post/save")
    public String postsSave(){
        return "post-save";
    }

    @GetMapping("/comment/save/{id}")
    public String commentSave(Model model, @PathVariable String id){

        model.addAttribute("id",id);

        return "comment-save";
    }

    @GetMapping("/comment/update/{id}")
    public String commentUpdate(@PathVariable Long id, Model model) {
        CommentResponseDto dto = commentService.findById(id);
        model.addAttribute("comment", dto);

        return "comment-update";
    }

    @GetMapping("/post/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        return "post-update";
    }
}
