package ru.kpfu.itis.baigulova.springsemesterwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Account;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Post;
import ru.kpfu.itis.baigulova.springsemesterwork.model.PostComment;
import ru.kpfu.itis.baigulova.springsemesterwork.security.details.AccountUserDetails;
import ru.kpfu.itis.baigulova.springsemesterwork.service.AccountService;
import ru.kpfu.itis.baigulova.springsemesterwork.service.PostCommentService;
import ru.kpfu.itis.baigulova.springsemesterwork.service.PostService;

@Controller
public class PostCommentController {

    private final PostCommentService postCommentService;
    private final PostService postService;
    private final AccountService accountService;

    @Autowired
    public PostCommentController(PostCommentService postCommentService, PostService postService, AccountService accountService) {
        this.postCommentService = postCommentService;
        this.postService = postService;
        this.accountService = accountService;
    }

    @PostMapping("/createPostComment/{postId}/{isMyPost}")
    public String savePostComment(@RequestParam("comment") String comment,
                                  @PathVariable("postId") Long postId,
                                  @PathVariable("isMyPost") Integer isMyPost, Authentication authentication) {

        Account account = ((AccountUserDetails) authentication.getPrincipal()).getAccount();
        Post post = postService.getRawPostById(postId);

        PostComment postComment = new PostComment(comment, account, post);
        postCommentService.save(postComment);

        return "redirect:/detailPost/" + postId + "/" + isMyPost;
    }
}

