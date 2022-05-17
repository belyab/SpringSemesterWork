package ru.kpfu.itis.baigulova.springsemesterwork.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.AccountDto;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.PostDto;
import ru.kpfu.itis.baigulova.springsemesterwork.helper.TextHelper;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Post;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.PostCommentDto;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Account;
import ru.kpfu.itis.baigulova.springsemesterwork.security.details.AccountUserDetails;
import ru.kpfu.itis.baigulova.springsemesterwork.service.AccountService;
import ru.kpfu.itis.baigulova.springsemesterwork.service.PostCommentService;
import ru.kpfu.itis.baigulova.springsemesterwork.service.PostService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PostController {

    private final PostService postService;
    private final AccountService accountService;
    private final PostCommentService postCommentService;

    @Autowired
    public PostController(PostService postService, AccountService accountService, PostCommentService postCommentService) {
        this.postService = postService;
        this.accountService = accountService;
        this.postCommentService = postCommentService;
    }

    @GetMapping("/allPosts")
    public String getAllPosts(Model model) {

        List<PostDto> allPosts = postService.getAll();
        Collections.reverse(allPosts);

        allPosts = allPosts.stream()
                .map(post -> new PostDto(post.getId(), post.getTitle(), TextHelper.editText(post.getText()),
                         post.getData(), post.getAccountId(), post.getAccountEmail()))
                .collect(Collectors.toList());

        model.addAttribute("allPosts", allPosts);

        return "allPostsPage";
    }

    @GetMapping("/allFindPosts")
    @ResponseBody
    public List<PostDto> getAllPostsByTitle(@RequestParam(value = "title",required = false) String title) {
        List<PostDto> posts = postService.getPostsByTitleLike(title);
        posts = posts.stream()
                .peek(post -> post.setText(TextHelper.editText(post.getText())))
                .collect(Collectors.toList());

        Collections.reverse(posts);

        return posts;
    }

    @GetMapping("/allMyFindPosts")
    @ResponseBody
    public List<PostDto> getAllMyPostsByTitle(@RequestParam(value = "title",required = false) String title,
                                                    Authentication authentication) {
        Account account = ((AccountUserDetails) authentication.getPrincipal()).getAccount();
        List<PostDto> posts = postService.getPostsByTitleLikeAndAccountId(title, account.getId());

        posts = posts.stream()
                .peek(post -> post.setText(TextHelper.editText(post.getText())))
                .collect(Collectors.toList());

        Collections.reverse(posts);

        return posts;
    }

    @GetMapping("/myPosts")
    public String getMyPosts(Authentication authentication, Model model) {

        Account account = ((AccountUserDetails) authentication.getPrincipal()).getAccount();
        List<PostDto> allPosts = postService.getAllByAccountId(account.getId());
        Collections.reverse(allPosts);

        allPosts = allPosts.stream()
                .map(post -> new PostDto(post.getId(), post.getTitle(), TextHelper.editText(post.getText()),
                         post.getData(), post.getAccountId(), post.getAccountEmail()))
                .collect(Collectors.toList());

        model.addAttribute("myPosts", allPosts);

        return "myPosts";
    }

    @GetMapping("/deletePost/{postId}")
    public String deletePost(@PathVariable("postId") Long postId) {
        postService.deletePostById(postId);

        return "redirect:/myPosts";
    }

    @GetMapping("/detailPost/{postId}/{isMyPost}")
    public String getDetailPost(@PathVariable("postId") Long postId,
                                   @PathVariable("isMyPost") Integer isMyPost, Model model) {

        PostDto post = postService.getPostById(postId);
        AccountDto author = accountService.getAccountById(post.getAccountId());
        List<PostCommentDto> comments = postCommentService.getAllByPostId(post.getId());

        if (isMyPost == 1) {
            model.addAttribute("isMyPost", true);
        }

        if (comments.size() != 0) {
            model.addAttribute("postComments", comments);
        }

        model.addAttribute("author", author);
        model.addAttribute("detailPost", post);

        return "detailsPost";
    }

    @GetMapping("/createPost")
    public String createPost() {

        return "addPost";
    }

    @PostMapping("/createPost")
    public String savePost(@RequestParam("title") String title, @RequestParam("content") String content, Authentication authentication) {

        Account account = ((AccountUserDetails) authentication.getPrincipal()).getAccount();

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

        Post post = new Post(title, content, formatForDateNow.format(date), account);

        postService.save(post);

        return "redirect:/profile";
    }


}
